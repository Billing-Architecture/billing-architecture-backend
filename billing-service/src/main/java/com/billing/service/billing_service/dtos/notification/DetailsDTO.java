package com.billing.service.billing_service.dtos.notification;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailsDTO {

    @JsonProperty("products")
    private List<ProductDTO> products;

    @JsonProperty("subtotal")
    private double subtotal;

    @JsonProperty("total")
    private double total;

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public List<ProductDTO> getProducts() {
        return products;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getTotal() {
        return total;
    }
}