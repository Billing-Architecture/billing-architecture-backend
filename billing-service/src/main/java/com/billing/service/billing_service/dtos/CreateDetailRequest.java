package com.billing.service.billing_service.dtos;

import com.billing.service.billing_service.domain.ProductsOrders;

public class CreateDetailRequest {
    private String email;
    private ProductsOrders detail[];

    public void setDetail(ProductsOrders detail) {
        this.detail = new ProductsOrders[]{detail};
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ProductsOrders[] getDetail() {
        return detail;
    }
    public String getEmail() {
        return email;
    }
}
