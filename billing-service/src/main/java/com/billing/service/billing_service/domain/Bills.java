package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @Column(name = "bill_order")
    private Orders billOrder;

    @Column(name = "bill_code")
    private int billCode;

    @Column(name = "bill_subtotal")
    private double billSubtotal;

    @Column(name = "bill_total")
    private double billTotal;

    @Column(name = "bill_total_paid")
    private double billTotalPaid;

    @Column(name = "bill_state")
    private String billState;

    @Column(name = "bill_created_at")
    private LocalDateTime billCreatedAt;

    public void setBillId(Long billId) {
        this.billId = billId;
    }
    public void setBillCode(int billCode) {
        this.billCode = billCode;
    }
    public void setBillOrder(Orders billOrder) {
        this.billOrder = billOrder;
    }
    public void setBillState(String billState) {
        this.billState = billState;
    }
    public void setBillSubtotal(double billSubtotal) {
        this.billSubtotal = billSubtotal;
    }
    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }
    public void setBillTotalPaid(double billTotalPaid) {
        this.billTotalPaid = billTotalPaid;
    }
    public void setBillCreatedAt(LocalDateTime billCreatedAt) {
        this.billCreatedAt = billCreatedAt;
    }
    public Long getBillId() {
        return billId;
    }
    public int getBillCode() {
        return billCode;
    }
    public Orders getBillOrder() {
        return billOrder;
    }
    public String getBillState() {
        return billState;
    }
    public double getBillSubtotal() {
        return billSubtotal;
    }
    public double getBillTotal() {
        return billTotal;
    }
    public double getBillTotalPaid() {
        return billTotalPaid;
    }
    public LocalDateTime getBillCreatedAt() {
        return billCreatedAt;
    }
}
