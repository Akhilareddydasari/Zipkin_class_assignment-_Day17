package com.example.orderservice.dto;
public class OrderResponse {
    private String orderId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String paymentStatus;
    private long totalProcessingMs;

    public OrderResponse() {}
    public OrderResponse(String orderId, String productName, Integer quantity, Double price,
                         String paymentStatus, long totalProcessingMs) {
        this.orderId = orderId; this.productName = productName; this.quantity = quantity;
        this.price = price; this.paymentStatus = paymentStatus; this.totalProcessingMs = totalProcessingMs;
    }
    public String getOrderId() { return orderId; }
    public String getProductName() { return productName; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public String getPaymentStatus() { return paymentStatus; }
    public long getTotalProcessingMs() { return totalProcessingMs; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public void setTotalProcessingMs(long totalProcessingMs) { this.totalProcessingMs = totalProcessingMs; }
}
