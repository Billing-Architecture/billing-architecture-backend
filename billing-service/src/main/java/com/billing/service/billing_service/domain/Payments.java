package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(name = "payment_bill")
    private Bills bill; 

    @Column(name = "payment_order")
    private Payments payment;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_total")
    private double paymentTotal;

    @Column(name = "payment_created_at")
    private LocalDateTime paymentCreatedAt;

    @Column(name = "payment_updated_at")
    private LocalDateTime paymentUpdatedAt;
    
    public void setBill(Bills bill) {
        this.bill = bill;
    }
    public void setPayment(Payments payment) {
        this.payment = payment;
    }
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    public void setPaymentCreatedAt(LocalDateTime paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
    public void setPaymentUpdatedAt(LocalDateTime paymentUpdatedAt) {
        this.paymentUpdatedAt = paymentUpdatedAt;
    }
    public Long getPaymentId() {
        return paymentId;
    }
    public Bills getBill() {
        return bill;
    }
    public Payments getPayment() {
        return payment;
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
    public LocalDateTime getPaymentUpdatedAt() {
        return paymentUpdatedAt;
    }
}
