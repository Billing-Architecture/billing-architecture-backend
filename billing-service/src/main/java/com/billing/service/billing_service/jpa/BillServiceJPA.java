package com.billing.service.billing_service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.services.IBillService;

@Service
@Primary
public class BillServiceJPA implements IBillService{
    @Autowired
    BillsRepository repository;

    @Override
    public Bills getBillById(Long billId) {
        return repository.findById(billId).orElse(null);
    }
}
