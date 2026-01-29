package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.ProductsOrders;

public interface IProductsOrdersService {
    void saveProductsOrders(ProductsOrders[] details);
    List<ProductsOrders> getProductsOrders();
    ProductsOrders byId(int id);
}