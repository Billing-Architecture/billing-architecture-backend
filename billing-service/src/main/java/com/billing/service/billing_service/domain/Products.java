package com.billing.service.billing_service.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
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
}
