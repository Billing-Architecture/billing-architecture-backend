package com.billing.service.billing_service.dtos;

import java.util.List;

import com.billing.service.billing_service.domain.ProductsOrders;

public class CreateDetailRequest {
    private String email;
    private List <ProductsOrders> detail;

    public void setDetail(List<ProductsOrders> detail) {
        this.detail = detail;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<ProductsOrders> getDetail() {
        return detail;
    }
    public String getEmail() {
        return email;
    }
}
