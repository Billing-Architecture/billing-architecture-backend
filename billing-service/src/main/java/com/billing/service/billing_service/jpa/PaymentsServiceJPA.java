package com.billing.service.billing_service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Payments;
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

    @Override
    @Transactional
    public void savePayment(Payments payment) {
        Bills bill = payment.getBill();
        double totalPaid = 0; 
        double totalPayment = payment.getPaymentTotal();

        for(Payments p : bill.getPayments()){
            totalPaid += p.getPaymentTotal();
        }

        double newPayment = payment.getPaymentTotal();
        double billTotal = bill.getBillTotal();

        if (totalPaid > (totalPaid + newPayment)) {
            throw new RuntimeException("El pago excede el total de la factura");
        }
        
        bill.getPayments().add(payment);
        bill.setBillTotalPaid(totalPaid + totalPayment);

        if (bill.getBillTotalPaid() == billTotal) {
            bill.setBillState("PAID");
        } else {
            bill.setBillState("PARTIAL");
        }
        repository.save(payment);
    }

    @Override
    public List<Payments> getPayment() {
        return repository.findAll();
    }
}
