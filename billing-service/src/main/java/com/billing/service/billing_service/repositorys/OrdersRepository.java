package com.billing.service.billing_service.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.service.billing_service.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {   
}