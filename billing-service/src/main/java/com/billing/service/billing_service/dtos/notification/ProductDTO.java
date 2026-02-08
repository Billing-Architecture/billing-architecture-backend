package com.billing.service.billing_service.dtos.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    
    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_quantity")
    private int productQuantity;

    @JsonProperty("product_price")
    private double productPrice;

    @JsonProperty("product_subtotal")
    private double productSubtotal;

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductSubtotal(double productSubtotal) {
        this.productSubtotal = productSubtotal;
    }
    public String getProductName() {
        return productName;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public double getProductSubtotal() {
        return productSubtotal;
    }
}
