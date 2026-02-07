package com.billing.service.billing_service.services;

import com.billing.service.billing_service.domain.Bills;

public interface IBillService {
    Bills getBillById(Long billId);
}
