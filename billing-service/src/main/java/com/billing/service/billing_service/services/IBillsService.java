package com.billing.service.billing_service.services;

import java.util.List;

import com.billing.service.billing_service.domain.Bills;

public interface IBillsService {
    void saveBill(Bills bill);
    List<Bills> getBills();
}