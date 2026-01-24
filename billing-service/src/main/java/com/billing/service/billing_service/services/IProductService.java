package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Products;

public interface IProductService {
    List<Products> getProducts();
    Products byId(int id);
    void saveProduct(Products product);
    void deleteProduct (int id);
}
