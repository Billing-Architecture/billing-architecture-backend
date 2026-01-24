package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
    public void setOrder_created_at(LocalDateTime order_created_at) {
        this.order_created_at = order_created_at;
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
}