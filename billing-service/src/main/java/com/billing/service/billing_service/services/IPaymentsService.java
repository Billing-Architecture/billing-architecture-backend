package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Payments;

public interface IPaymentsService {
    void savePayment(Payments payment);
    List<Payments> getPayment();
}
