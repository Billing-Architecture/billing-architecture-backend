package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.repositorys.PaymentsRepository;
import com.billing.service.billing_service.services.IPaymentsService;

@Service
@Primary
public class PaymentsServiceJPA implements IPaymentsService{
    
    @Autowired
    PaymentsRepository repository;

    @Override
    public void savePayment(Payments payment) {
        repository.save(payment);
    }

    @Override
    public List<Payments> getPayment() {
        return repository.findAll();
    }

}
