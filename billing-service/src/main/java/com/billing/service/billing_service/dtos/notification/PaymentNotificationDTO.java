package com.billing.service.billing_service.dtos.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentNotificationDTO extends NotificationRequest{

    @JsonProperty("payment")
    private PaymentDTO payment;

    @JsonProperty("bill")
    private BillDTO bill;

    public PaymentDTO getPayment() {
        return payment;
    }
    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }
    public BillDTO getBill() {
        return bill;
    }
    public void setBill(BillDTO bill) {
        this.bill = bill;
    }
}
