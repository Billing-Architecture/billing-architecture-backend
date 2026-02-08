package com.billing.service.billing_service.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.dtos.CreatePaymentRequest;
import com.billing.service.billing_service.services.IBillService;
import com.billing.service.billing_service.services.INotificationService;
import com.billing.service.billing_service.services.IPaymentsService;

@Controller
@RequestMapping("payments")
public class PaymentController {
    @Autowired
    private IPaymentsService service;

    @Autowired INotificationService notifyService;

    @Autowired IBillService billService;

    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    @ResponseBody
    public Map listPayments() {
        return Collections.singletonMap("payments", service.getPayment());
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    @ResponseBody
    public Map createPayment(@RequestBody @Validated CreatePaymentRequest payment) {
        Payments savePayment = service.savePayment(payment.getPayment());
        Bills saveBill = billService.getBillById(payment.getPayment().getBill().getBillId());
        notifyService.sendEmail(savePayment, saveBill, payment.getEmail());
        return listPayments();
    }
}
