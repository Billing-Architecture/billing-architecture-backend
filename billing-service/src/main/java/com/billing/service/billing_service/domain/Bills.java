package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Orders order;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payments> payments = new ArrayList<>();

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
    public void setOrder(Orders order) {
        this.order = order;
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
    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
    public Long getBillId() {
        return billId;
    }
    public int getBillCode() {
        return billCode;
    }
    public Orders getOrder() {
        return order;
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
    public List<Payments> getPayments() {
        return payments;
    }
}
