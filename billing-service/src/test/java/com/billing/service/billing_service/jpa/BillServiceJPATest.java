package com.billing.service.billing_service.jpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.repositorys.BillsRepository;

@ExtendWith(MockitoExtension.class)
public class BillServiceJPATest {
    
    @Mock   
    private BillsRepository repository;

    @InjectMocks
    private BillServiceJPA serviceJPA;

    @Test
    void shouldReturnBillById () {
        Long billId = 1L;

        Bills bill = new Bills();
        bill.setBillId(billId);
        bill.setBillTotalPaid(999);;

        when(repository.findById(billId)).thenReturn(Optional.of(bill));

        Bills result = serviceJPA.getBillById(billId);
        assertEquals(bill, result);
    }

    @Test
    void shouldNotReturnBillById () {
        Long billId = 1L;

        Bills bill = new Bills();
        bill.setBillId(billId);
        bill.setBillTotalPaid(999);;

        when(repository.findById(billId)).thenReturn(Optional.empty());

        Bills result = serviceJPA.getBillById(billId);
        assertEquals(null, result);
    }
}
