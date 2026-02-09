package com.billing.service.billing_service.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.repositorys.PaymentsRepository;

@ExtendWith(MockitoExtension.class)
public class PaymentsServiceJPATest {
    
    @Mock
    private PaymentsRepository repositoryPayment;

    @InjectMocks
    private PaymentsServiceJPA serviceJPA;

    @Mock
    private OrdersRepository repositoryOrders;

    @Mock
    private BillsRepository repositoryBill;


    @Test
    void shouldReturnPayments () {
        Payments payments = new Payments();
        when(repositoryPayment.findAll()).thenReturn(List.of(payments));
        List<Payments> result = serviceJPA.getPayment();
        assertEquals(1, result.size());
        verify(repositoryPayment).findAll();
    } 

    @Test
    void shouldRegisterPartialPayment() {

        Bills bill = new Bills();
        bill.setBillId(1L);
        bill.setBillTotal(100);
        bill.setBillTotalPaid(0);
        bill.setPayments(new ArrayList<>());

        Payments payment = new Payments();
        payment.setPaymentTotal(40);
        payment.setBill(bill);

        when(repositoryBill.findById(1L)).thenReturn(Optional.of(bill));
        when(repositoryPayment.save(any())).thenAnswer(i -> i.getArgument(0));

        serviceJPA.savePayment(payment);

        assertEquals(40, bill.getBillTotalPaid());
        assertEquals("PARTIAL", bill.getBillState());
        assertEquals(1, bill.getPayments().size());

        verify(repositoryPayment).save(payment);
    }

    @Test
    void shouldRegisterFullPaymentAndMarkBillAsPaid() {
        Bills bill = new Bills();
        bill.setBillId(1L);
        bill.setBillTotal(100);
        bill.setBillTotalPaid(0);
        bill.setPayments(new ArrayList<>());

        Payments previous = new Payments();
        previous.setPaymentTotal(60);
        bill.getPayments().add(previous);

        Payments payment = new Payments();
        payment.setPaymentTotal(40);
        payment.setBill(bill);

        when(repositoryBill.findById(1L)).thenReturn(Optional.of(bill));
        when(repositoryPayment.save(any())).thenAnswer(i -> i.getArgument(0));

        serviceJPA.savePayment(payment);

        assertEquals(100, bill.getBillTotalPaid());
        assertEquals("PAID", bill.getBillState());

        verify(repositoryPayment).save(payment);
    }

    @Test
    void shouldThrowExceptionWhenPaymentExceedsBillTotal() {
        Bills bill = new Bills();
        bill.setBillId(1L);
        bill.setBillTotal(100);
        bill.setBillTotalPaid(80);
        bill.setPayments(new ArrayList<>());

        Payments previous = new Payments();
        previous.setPaymentTotal(80);
        bill.getPayments().add(previous);

        Payments payment = new Payments();
        payment.setPaymentTotal(30);
        payment.setBill(bill);

        when(repositoryBill.findById(1L)).thenReturn(Optional.of(bill));

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> serviceJPA.savePayment(payment)
        );

        assertEquals("The payment exceeds the total invoice amount", exception.getMessage());
        verify(repositoryPayment, never()).save(any());
    }                                                                           
}