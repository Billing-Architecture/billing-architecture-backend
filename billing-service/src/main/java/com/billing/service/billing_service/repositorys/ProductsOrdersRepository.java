package com.billing.service.billing_service.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.service.billing_service.domain.ProductsOrders;

public interface ProductsOrdersRepository extends JpaRepository<ProductsOrders, Long>{
}
