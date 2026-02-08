package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.dtos.ProductOrderItemRequest;

public interface IProductsOrdersService {
    Bills saveProductsOrders(List<ProductOrderItemRequest > details);
    List<ProductsOrders> getProductsOrders();
    ProductsOrders byId(Long id);
}