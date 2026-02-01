package com.billing.service.billing_service.dtos;

import java.time.LocalDate;

public class PaymentNotificationDTO extends NotificationRequest{
    private String paymentType;
    private Integer paymentTotal;
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
