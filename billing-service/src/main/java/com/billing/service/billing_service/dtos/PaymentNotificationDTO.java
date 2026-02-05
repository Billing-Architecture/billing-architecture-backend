package com.billing.service.billing_service.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentNotificationDTO extends NotificationRequest{

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_total")
    private double paymentTotal;

    @JsonProperty("payment_created_at")
    private LocalDateTime paymentCreatedAt;

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    public void setPaymentCreatedAt(LocalDateTime paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public double getPaymentTotal() {
        return paymentTotal;
    }
    public LocalDateTime getPaymentCreatedAt() {
        return paymentCreatedAt;
    }
}
