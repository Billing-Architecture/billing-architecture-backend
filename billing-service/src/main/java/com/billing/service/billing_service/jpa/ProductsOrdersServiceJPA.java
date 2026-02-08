package com.billing.service.billing_service.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Orders;
import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.dtos.ProductOrderItemRequest;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.repositorys.ProductsOrdersRepository;
import com.billing.service.billing_service.repositorys.ProductsRepository;
import com.billing.service.billing_service.services.IProductsOrdersService;

@Service
@Primary
public class ProductsOrdersServiceJPA implements IProductsOrdersService{

    @Autowired
    ProductsOrdersRepository repositoryDetails;

    @Autowired
    OrdersRepository repositoryOrder;

    @Autowired
    BillsRepository repositoryBill;

    @Autowired
    ProductsRepository repositoryProduct;

    @Transactional
    @Override
    public Bills saveProductsOrders(List<ProductOrderItemRequest> details) {

        Orders order = new Orders();
        order.setOrderState("Pending");
        order.setOrder_created_at(LocalDateTime.now());
        
        double descount = 0;
        double tax = 0;
        double subTotal = 0;
        double total = 0;

        double subTotalBill = 0;
        double totalBill = 0;

        for(ProductOrderItemRequest item : details){
            System.out.println("Product ID: " + item.getProductId() + ", Quantity: " + item.getQuantity());
            Products product = repositoryProduct
                .findById(item.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

            ProductsOrders detail = new ProductsOrders();
            detail.setProduct(product);
            detail.setOrder(order);
            detail.setProductsOrdersPrice(product.getProductDefaultPrice());
            detail.setProductsOrdersQuantity(item.getQuantity());

            subTotal = 
                product.getProductDefaultPrice() * 
                item.getQuantity();

            descount = 
                (product.getProductDescountPercentage() * 
                product.getProductDefaultPrice()) * 
                item.getQuantity();

            tax = product.getProductTaxPercentage() * 
                product.getProductDefaultPrice() * 
                item.getQuantity();

            total = (subTotal-descount) + tax;

            detail.setProductsOrdersSubtotal(subTotal);
            detail.setProductsOrdersTotal(total);

            subTotalBill += subTotal;
            totalBill += total;

            order.getProducts().add(detail);
        }

        order = repositoryOrder.save(order);

        Bills bill = new Bills();
        bill.setBillCode("BILL-" + order.getOrderId());
        bill.setBillTotalPaid(0);
        bill.setBillSubtotal(subTotalBill);
        bill.setBillTotal(totalBill);
        bill.setBillState("Pending");
        bill.setBillCreatedAt(LocalDateTime.now());
        bill.setOrder(order);

        return repositoryBill.save(bill);
    }

    @Override
    public List<ProductsOrders> getProductsOrders() {
        return repositoryDetails.findAll();
    }

    @Override
    public ProductsOrders byId(Long id) {
        return repositoryDetails.findById(id).orElseThrow(() -> new RuntimeException("Detail not found."));
    }
}
