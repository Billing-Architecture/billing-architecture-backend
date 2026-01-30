package com.billing.service.billing_service.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.service.billing_service.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
}