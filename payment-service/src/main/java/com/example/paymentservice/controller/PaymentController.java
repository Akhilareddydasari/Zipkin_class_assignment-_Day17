package com.example.paymentservice.controller;
import com.example.paymentservice.dto.PaymentRequest;
import com.example.paymentservice.dto.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> process(@Validated @RequestBody PaymentRequest req) throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("Payment received for orderId={}, customer={}, amount={}", req.getOrderId(), req.getCustomerName(), req.getAmount());

        // Simulate payment (e.g., 120ms latency)
        Thread.sleep(120);

        String status = "APPROVED";
        long took = System.currentTimeMillis() - start;
        log.info("Payment processed for orderId={} status={} in {} ms", req.getOrderId(), status, took);

        return ResponseEntity.ok(new PaymentResponse(req.getOrderId(), status, took));
    }
}
