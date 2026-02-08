package com.billing.service.billing_service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.billing.service.billing_service.client.NotificationClient;
import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.dtos.notification.BillDTO;
import com.billing.service.billing_service.dtos.notification.BillNotificationDTO;
import com.billing.service.billing_service.dtos.notification.DetailsDTO;
import com.billing.service.billing_service.dtos.notification.PaymentDTO;
import com.billing.service.billing_service.dtos.notification.PaymentNotificationDTO;
import com.billing.service.billing_service.dtos.notification.ProductDTO;
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
        notification.setBillCode(details.getBillCode());
        notification.setBillIssueDate(details.getBillCreatedAt());
        notification.setNotificationReceiver(email);
        notification.setNotificationSubject("Purchase invoice");
        notification.setReferenceId(details.getBillId());
        notification.setNotificationMessage("Thank you for your purchase. We have attached the invoice in PDF format.");
        notification.setNotificationReferenceType("INVOICE");
        
        DetailsDTO detailDto = new DetailsDTO();
        detailDto.setSubtotal(details.getBillSubtotal());
        detailDto.setTotal(details.getBillTotal());
        notification.setDetails(detailDto);

        List<ProductDTO> products = new ArrayList<>();
        List<ProductsOrders> listTemp = details.getOrder().getProducts();

        for(ProductsOrders item : listTemp){
            ProductDTO product = new ProductDTO();
            product.setProductName(item.getProduct().getProductName());
            product.setProductPrice(item.getProductsOrdersPrice());
            product.setProductQuantity(item.getProductsOrdersQuantity());
            products.add(product);
        }
        
        detailDto.setProducts(products);
        
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
