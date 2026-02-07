package com.billing.service.billing_service.dtos;

import java.util.List;

public class CreateDetailRequest {
    private String email;
    private List <ProductOrderItemRequest> detail;

    public void setDetail(List<ProductOrderItemRequest> detail) {
        this.detail = detail;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<ProductOrderItemRequest> getDetail() {
        return detail;
    }
    public String getEmail() {
        return email;
    }
}
