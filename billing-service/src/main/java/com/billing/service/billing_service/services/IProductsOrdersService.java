package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.ProductsOrders;

public interface IProductsOrdersService {
    Bills saveProductsOrders(ProductsOrders[] details, String email);
    List<ProductsOrders> getProductsOrders();
    ProductsOrders byId(int id);
}