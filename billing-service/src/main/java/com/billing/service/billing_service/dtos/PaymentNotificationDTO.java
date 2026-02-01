package com.billing.service.billing_service.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentNotificationDTO extends NotificationRequest{

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_total")
    private Integer paymentTotal;

    @JsonProperty("payment_created_at")
    private LocalDate paymentCreatedAt;

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setPaymentTotal(Integer paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    public void setPaymentCreatedAt(LocalDate paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public Integer getPaymentTotal() {
        return paymentTotal;
    }
    public LocalDate getPaymentCreatedAt() {
        return paymentCreatedAt;
    }
}
