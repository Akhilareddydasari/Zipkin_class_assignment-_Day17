package com.example.orderservice.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {
    @NotBlank
    private String orderId;
    @NotBlank
    private String customerName;
    @NotBlank
    private String productName;
    @NotNull @Min(1)
    private Integer quantity;
    @NotNull @Min(1)
    private Double price;

    public OrderRequest() {}
    public OrderRequest(String orderId, String customerName, String productName, Integer quantity, Double price) {
        this.orderId = orderId; this.customerName = customerName; this.productName = productName;
        this.quantity = quantity; this.price = price;
    }
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getProductName() { return productName; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
}
