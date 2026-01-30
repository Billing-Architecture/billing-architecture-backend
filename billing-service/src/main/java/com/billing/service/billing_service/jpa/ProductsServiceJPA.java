package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.repositorys.ProductsRepository;
import com.billing.service.billing_service.services.IProductService;

@Service
@Primary
public class ProductsServiceJPA implements IProductService{

    @Autowired
    ProductsRepository repository; 

    @Override
    public List<Products> getProducts() {
        return repository.findAll();
    }

    @Override
    public Products byId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveProduct(Products product) {
        repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }    
}
