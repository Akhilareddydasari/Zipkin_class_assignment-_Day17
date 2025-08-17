package com.example.paymentservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentRequest {
    @NotBlank
    private String orderId;
    @NotBlank
    private String customerName;
    @NotNull @Min(1)
    private Double amount;

    public PaymentRequest() {}
    public PaymentRequest(String orderId, String customerName, Double amount) {
        this.orderId = orderId; this.customerName = customerName; this.amount = amount;
    }
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public Double getAmount() { return amount; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setAmount(Double amount) { this.amount = amount; }
}
