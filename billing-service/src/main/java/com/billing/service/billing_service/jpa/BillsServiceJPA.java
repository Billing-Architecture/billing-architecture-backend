package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.services.IBillsService;

@Service
@Primary
public class BillsServiceJPA implements IBillsService{

    @Autowired
    BillsRepository repository;

    @Override
    public void saveBill(Bills bill) {
        repository.save(bill);
    }

    @Override
    public List<Bills> getBills() {
        return repository.findAll();
    }
    
}
