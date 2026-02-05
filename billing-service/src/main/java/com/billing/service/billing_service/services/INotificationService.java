package com.billing.service.billing_service.services;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;

public interface INotificationService {
    void sendEmail(Bills details, String email);
    void sendEmail(Payments payments, String email);
}