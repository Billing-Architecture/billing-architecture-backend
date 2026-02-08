package com.billing.service.billing_service.dtos.notification;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDTO {

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_total")
    private double paymentTotal;

    @JsonProperty("payment_created_at")
    private LocalDate paymentCreatedAt;

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
    public LocalDate getPaymentCreatedAt() {
        return paymentCreatedAt;
    }
    public void setPaymentCreatedAt(LocalDate paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
}

