package com.billing.service.billing_service.services;

import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.domain.ProductsOrders;

public interface INotificationService {
    void sendDetails(ProductsOrders details);
    void sendPayment(Payments payments);
}