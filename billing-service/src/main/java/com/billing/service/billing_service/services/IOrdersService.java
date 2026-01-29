package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Orders;

public interface IOrdersService {
    Orders createOrders(Orders order); 
    List<Orders> getOrders();
}
