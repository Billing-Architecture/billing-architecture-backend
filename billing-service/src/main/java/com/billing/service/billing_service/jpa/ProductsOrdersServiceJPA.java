package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.repositorys.ProductsOrdersRepository;
import com.billing.service.billing_service.services.IProductsOrdersService;

@Service
@Primary
public class ProductsOrdersServiceJPA implements IProductsOrdersService{

    @Autowired
    ProductsOrdersRepository repository;

    @Override
    public void saveProductsOrders(ProductsOrders details) {
        repository.save(details);
    }

    @Override
    public List<ProductsOrders> getProductsOrders() {
        return repository.findAll();
    }

    @Override
    public ProductsOrders byId(int id) {
        return repository.findById(id).get();
    }
}
