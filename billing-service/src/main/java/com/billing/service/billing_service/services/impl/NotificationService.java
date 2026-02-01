package com.billing.service.billing_service.services.impl;

import org.springframework.stereotype.Service;

import com.billing.service.billing_service.client.NotificationClient;
import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.dtos.BillNotificationDTO;
import com.billing.service.billing_service.dtos.PaymentNotificationDTO;
import com.billing.service.billing_service.services.INotificationService;

@Service
public class NotificationService implements INotificationService{

    private final NotificationClient service;

    public NotificationService (NotificationClient service) {
        this.service = service;
    }

    @Override
    public void sendEmail(Bills details) {
        BillNotificationDTO notification = new BillNotificationDTO();
        notification.setReferenceId(details.getBillId());
        notification.setNotificationSubject("Purchase invoice");
        notification.setNotificationMessage("Thank you for your purchase. We have attached the invoice in PDF format.");
        notification.setNotificationReferenceType("INVOICE");
        notification.setNotificationReceiver("email@example.com");
        notification.setBillCode("");
        notification.setBillToPay(details.getBillTotal());
        notification.setBillTotal(details.getBillTotal());
        notification.setBillTotalPaid(details.getBillTotalPaid());

        service.sendNotification(notification);
    }

    @Override
    public void sendEmail(Payments payments) {
        PaymentNotificationDTO notification = new PaymentNotificationDTO();
        notification.setReferenceId(notification.getReferenceId());
        notification.setNotificationSubject("Payment invoice");
        notification.setNotificationMessage("Thank you for your purchase.");
        notification.setNotificationReferenceType("PAYMENT");
        notification.setNotificationReceiver("email@example.com");
        notification.setPaymentType(notification.getPaymentType());
        notification.setPaymentTotal(notification.getPaymentTotal());
        notification.setPaymentCreatedAt(notification.getPaymentCreatedAt());

        service.sendNotification(notification);
    }
}
