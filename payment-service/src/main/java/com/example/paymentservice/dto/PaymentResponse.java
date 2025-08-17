package com.example.paymentservice.dto;

public class PaymentResponse {
    private String orderId;
    private String status; // APPROVED / DECLINED
    private long processingMs;

    public PaymentResponse() {}
    public PaymentResponse(String orderId, String status, long processingMs) {
        this.orderId = orderId; this.status = status; this.processingMs = processingMs;
    }
    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public long getProcessingMs() { return processingMs; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setStatus(String status) { this.status = status; }
    public void setProcessingMs(long processingMs) { this.processingMs = processingMs; }
}
