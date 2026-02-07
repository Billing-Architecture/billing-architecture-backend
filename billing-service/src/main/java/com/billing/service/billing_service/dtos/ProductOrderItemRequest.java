package com.billing.service.billing_service.dtos;

public class ProductOrderItemRequest {
    private Long productId;
    private int quantity;

    public Long getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
}
