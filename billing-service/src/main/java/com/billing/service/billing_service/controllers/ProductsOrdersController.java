package com.billing.service.billing_service.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billing.service.billing_service.services.IProductsOrdersService;

@Controller
@RequestMapping("details")
public class ProductsOrdersController {
    @Autowired
    private IProductsOrdersService service;

    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    @ResponseBody
    public Map listDetails() {
        return Collections.singletonMap("details", service.getProductsOrders());
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    @ResponseBody
    public Map createDetails() {
        return listDetails();
    }
}