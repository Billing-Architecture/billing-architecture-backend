package com.billing.service.billing_service.dtos;

import com.billing.service.billing_service.domain.Payments;

public class CreatePaymentRequest {
    
    private String email;
    private Payments payment;

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPayment(Payments payment) {
        this.payment = payment;
    }
    public String getEmail() {
        return email;
    }
    public Payments getPayment() {
        return payment;
    }
}
