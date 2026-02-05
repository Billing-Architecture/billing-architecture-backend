package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bills bill;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_total")
    private double paymentTotal;

    @Column(name = "payment_user_email")
    private String paymentUserEmail;

    @Column(name = "payment_created_at")
    private LocalDateTime paymentCreatedAt;

    @Column(name = "payment_updated_at")
    private LocalDateTime paymentUpdatedAt;
    
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }
    public void setPaymentUserEmail(String paymentUserEmail) {
        this.paymentUserEmail = paymentUserEmail;
    }
    public void setPaymentCreatedAt(LocalDateTime paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
    public void setPaymentUpdatedAt(LocalDateTime paymentUpdatedAt) {
        this.paymentUpdatedAt = paymentUpdatedAt;
    }
    public void setBill(Bills bill) {
        this.bill = bill;
    }
    public Long getPaymentId() {
        return paymentId;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public double getPaymentTotal() {
        return paymentTotal;
    }
    public String getPaymentUserEmail() {
        return paymentUserEmail;
    }
    public LocalDateTime getPaymentCreatedAt() {
        return paymentCreatedAt;
    }
    public LocalDateTime getPaymentUpdatedAt() {
        return paymentUpdatedAt;
    }
    public Bills getBill() {
        return bill;
    }
}
