package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_default_price")
    private double productDefaultPrice;

    @Column(name = "product_tax_percentage")
    private double productTaxPercentage;

    @Column(name = "product_descount_percentage")
    private double productDescountPercentage;

    @Column(name = "product_created_at")
    private LocalDateTime productCreatedAt;

    @Column(name = "product_updated_at")
    private LocalDateTime productUpdatedAt;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductsOrders> orders = new ArrayList<>();

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public void setProductDefaultPrice(double productDefaultPrice) {
        this.productDefaultPrice = productDefaultPrice;
    }
    public void setProductTaxPercentage(double productTaxPercentage) {
        this.productTaxPercentage = productTaxPercentage;
    }
    public void setProductDescountPercentage(double productDescountPercentage) {
        this.productDescountPercentage = productDescountPercentage;
    }
    public void setProductCreatedAt(LocalDateTime productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }
    public void setProductUpdatedAt(LocalDateTime productUpdatedAt) {
        this.productUpdatedAt = productUpdatedAt;
    }
    public void setOrders(List<ProductsOrders> orders) {
        this.orders = orders;
    }
    public Long getProductId() {
        return productId;
    }
    public String getProductCode() {
        return productCode;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public double getProductDefaultPrice() {
        return productDefaultPrice;
    }
    public double getProductTaxPercentage() {
        return productTaxPercentage;
    }
    public double getProductDescountPercentage() {
        return productDescountPercentage;
    }
    public LocalDateTime getProductCreatedAt() {
        return productCreatedAt;
    }
    public LocalDateTime getProductUpdatedAt() {
        return productUpdatedAt;
    }
    public List<ProductsOrders> getOrders() {
        return orders;
    }
}
