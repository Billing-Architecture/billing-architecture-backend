package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "details")
public class ProductsOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_orders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Products product;

    @Column(name = "products_orders_quantity")
    private int productsOrdersQuantity;

    @Column(name = "products_orders_price")
    private double productsOrdersPrice;

    @Column(name = "products_orders_subtotal")
    private double productsOrdersSubtotal;

    @Column(name = "products_orders_total")
    private double productsOrdersTotal;

    @Column(name = "products_orders_updated_at")
    private LocalDateTime productsOrdersUpdatedAt;

    public void setId(Long id) {
        this.id = id;
    }
    public void setOrder(Orders order) {
        this.order = order;
    }
    public void setProduct(Products product) {
        this.product = product;
    }
    public void setProductsOrdersQuantity(int productsOrdersQuantity) {
        this.productsOrdersQuantity = productsOrdersQuantity;
    }
    public void setProductsOrdersPrice(double productsOrdersPrice) {
        this.productsOrdersPrice = productsOrdersPrice;
    }
    public void setProductsOrdersSubtotal(double productsOrdersSubtotal) {
        this.productsOrdersSubtotal = productsOrdersSubtotal;
    }
    public void setProductsOrdersTotal(double productsOrdersTotal) {
        this.productsOrdersTotal = productsOrdersTotal;
    }
    public void setProductsOrdersUpdatedAt(LocalDateTime productsOrdersUpdatedAt) {
        this.productsOrdersUpdatedAt = productsOrdersUpdatedAt;
    }

    public Long getId() {
        return id;
    }
    public Orders getOrder() {
        return order;
    }
    public Products getProduct() {
        return product;
    }
    public int getProductsOrdersQuantity() {
        return productsOrdersQuantity;
    }
    public double getProductsOrdersPrice() {
        return productsOrdersPrice;
    }
    public double getProductsOrdersSubtotal() {
        return productsOrdersSubtotal;
    }
    public double getProductsOrdersTotal() {
        return productsOrdersTotal;
    }
    public LocalDateTime getProductsOrdersUpdatedAt() {
        return productsOrdersUpdatedAt;
    }
}
