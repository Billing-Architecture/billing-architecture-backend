package com.billing.service.billing_service.services.impl;

import org.springframework.stereotype.Service;

import com.billing.service.billing_service.client.NotificationClient;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.services.INotificationService;

@Service
public class NotificationService implements INotificationService{

    private final NotificationClient service;

    public NotificationService (NotificationClient service) {
        this.service = service;
    }

    @Override
    public void sendDetails(ProductsOrders details) {
        
    }

    @Override
    public void sendPayment(Payments payments) {
        
    }
    
}
