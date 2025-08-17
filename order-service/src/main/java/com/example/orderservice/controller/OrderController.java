package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Validated @RequestBody OrderRequest req) {
        long start = System.currentTimeMillis();
        log.info("Create order start orderId={} product={} qty={} price={}",
                req.getOrderId(), req.getProductName(), req.getQuantity(), req.getPrice());

        double amount = req.getPrice() * req.getQuantity();

        // Build Payment request payload
        Map<String, Object> paymentReq = Map.of(
                "orderId", req.getOrderId(),
                "customerName", req.getCustomerName(),
                "amount", amount
        );

        // Call Payment Service (propagates trace context automatically)
        ResponseEntity<Map> paymentResp = restTemplate.postForEntity(
                "http://localhost:8082/payments/process", paymentReq, Map.class);

        String paymentStatus = String.valueOf(paymentResp.getBody().get("status"));
        long took = System.currentTimeMillis() - start;
        log.info("Create order end orderId={} paymentStatus={} totalMs={}", req.getOrderId(), paymentStatus, took);

        OrderResponse response = new OrderResponse(
                req.getOrderId(), req.getProductName(), req.getQuantity(), req.getPrice(), paymentStatus, took);

        return ResponseEntity.ok(response);
    }
}
