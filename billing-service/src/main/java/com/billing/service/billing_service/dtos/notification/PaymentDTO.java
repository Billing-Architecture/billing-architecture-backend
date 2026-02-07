package com.billing.service.billing_service.dtos.notification;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDTO {

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_total")
    private double paymentTotal;

    @JsonProperty("payment_created_at")
    private LocalDateTime paymentCreatedAt;

    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public double getPaymentTotal() {
        return paymentTotal;
    }
    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    public LocalDateTime getPaymentCreatedAt() {
        return paymentCreatedAt;
    }
    public void setPaymentCreatedAt(LocalDateTime paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
}

