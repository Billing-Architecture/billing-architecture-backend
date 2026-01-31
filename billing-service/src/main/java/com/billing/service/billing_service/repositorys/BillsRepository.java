package com.billing.service.billing_service.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.service.billing_service.domain.Bills;

public interface BillsRepository extends JpaRepository<Bills, Long>{
}