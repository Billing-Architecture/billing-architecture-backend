package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.Orders;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.services.IOrdersService;

@Service
@Primary
public class OrdersServiceJPA implements IOrdersService{

    @Autowired
    OrdersRepository repository;
    
    @Override
    public Orders createOrders(Orders order) {
        return repository.save(order);
    }

    @Override
    public List<Orders> getOrders() {
        return repository.findAll();
    }
}
