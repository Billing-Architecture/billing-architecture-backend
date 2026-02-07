package com.billing.service.billing_service.services.impl;

import org.springframework.stereotype.Service;

import com.billing.service.billing_service.client.NotificationClient;
import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.dtos.notification.BillDTO;
import com.billing.service.billing_service.dtos.notification.BillNotificationDTO;
import com.billing.service.billing_service.dtos.notification.PaymentDTO;
import com.billing.service.billing_service.dtos.notification.PaymentNotificationDTO;
import com.billing.service.billing_service.services.INotificationService;

@Service
public class NotificationService implements INotificationService{

    private final NotificationClient service;

    public NotificationService (NotificationClient service) {
        this.service = service;
    }

    @Override
    public void sendEmail(Bills details, String email) {
        BillNotificationDTO notification = new BillNotificationDTO();
        notification.setReferenceId(details.getBillId());
        notification.setNotificationSubject("Purchase invoice");
        notification.setNotificationMessage("Thank you for your purchase. We have attached the invoice in PDF format.");
        notification.setNotificationReferenceType("INVOICE");
        notification.setNotificationReceiver(email);
        notification.setBillCode(details.getBillCode());
        notification.setBillToPay(details.getBillTotal());
        notification.setBillTotal(details.getBillTotal());
        notification.setBillTotalPaid(details.getBillTotalPaid());

        service.sendNotification(notification);
    }

    @Override
    public void sendEmail(Payments payments, Bills saveBill, String email) {

        PaymentNotificationDTO notification = new PaymentNotificationDTO();
        notification.setReferenceId(payments.getPaymentId());
        notification.setNotificationSubject("Payment invoice");
        notification.setNotificationMessage("Thank you for your purchase.");
        notification.setNotificationReferenceType("PAYMENT");
        notification.setNotificationReceiver(email);

        PaymentDTO payment = new PaymentDTO();
        payment.setPaymentType(payments.getPaymentType());
        payment.setPaymentTotal(payments.getPaymentTotal());
        payment.setPaymentCreatedAt(payments.getPaymentCreatedAt());
        notification.setPayment(payment);

        BillDTO bill = new BillDTO();
        bill.setBillCode(saveBill.getBillCode());
        bill.setBillTotal(saveBill.getBillTotal());
        bill.setBillTotalPaid(saveBill.getBillTotalPaid());
        notification.setBill(bill);

        service.sendNotification(notification);
    }
}
