package com.billing.service.billing_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.dtos.CreateDetailRequest;
import com.billing.service.billing_service.services.INotificationService;
import com.billing.service.billing_service.services.IProductsOrdersService;

@Controller
@RequestMapping("details")
public class ProductsOrdersController {
    @Autowired
    private IProductsOrdersService service;

    @Autowired
    private INotificationService notifyService;

    @GetMapping("/list")
    @ResponseBody
    public List<ProductsOrders> listDetails() {
        return service.getProductsOrders();
    }

    @PostMapping("/add")
    @ResponseBody
    public List<ProductsOrders> createDetails(@RequestBody @Validated CreateDetailRequest request) {
        ProductsOrders[] details = request.getDetail();
        String email = request.getEmail();
        Bills saveBill = service.saveProductsOrders(details);
        notifyService.sendEmail(saveBill, email);
        return listDetails();   
    }
}