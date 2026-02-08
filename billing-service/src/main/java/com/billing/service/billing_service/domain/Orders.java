package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_state")
    private String orderState;

    @Column(name = "order_created_at")
    private LocalDateTime order_created_at;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JsonIgnore
    private List<ProductsOrders> products = new ArrayList<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Bills bill;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
    public void setOrder_created_at(LocalDateTime order_created_at) {
        this.order_created_at = order_created_at;
    }
    public void setProducts(List<ProductsOrders> products) {
        this.products = products;
    }
    public void setBill(Bills bill) {
        this.bill = bill;
    }
    public Long getOrderId() {
        return orderId;
    }
    public String getOrderState() {
        return orderState;
    }
    public LocalDateTime getOrder_created_at() {
        return order_created_at;
    }
    public List<ProductsOrders> getProducts() {
        return products;
    }
    public Bills getBill() {
        return bill;
    }
}