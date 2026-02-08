package com.billing.service.billing_service.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.repositorys.PaymentsRepository;
import com.billing.service.billing_service.services.IPaymentsService;

@Service
@Primary
public class PaymentsServiceJPA implements IPaymentsService{
    
    @Autowired
    PaymentsRepository repository;

    @Autowired
    OrdersRepository repositoryOrder;

    @Autowired
    BillsRepository repositoryBill;

    @Override
    @Transactional
    public Payments savePayment(Payments payment) {
        Bills bill = repositoryBill.findById(payment.getBill().getBillId()).orElseThrow(() -> new RuntimeException("Bill not found"));
        double totalPaid = 0; 
        double totalPayment = payment.getPaymentTotal();

        for(Payments p : bill.getPayments()){
            totalPaid += p.getPaymentTotal();
        }

        double newPayment = payment.getPaymentTotal();
        double billTotal = bill.getBillTotal();

        if (totalPaid + newPayment > billTotal) {
            throw new RuntimeException("The payment exceeds the total invoice amount");
        }

        payment.setBill(bill);
        bill.getPayments().add(payment);
        
        bill.setBillTotalPaid(totalPaid + totalPayment);
        bill.setBillState(
            bill.getBillTotalPaid() == billTotal ? "PAID" : "PARTIAL"
        );
        
        payment.setPaymentCreatedAt(LocalDateTime.now());

        return repository.save(payment);
    }

    @Override
    public List<Payments> getPayment() {
        return repository.findAll();
    }
}
