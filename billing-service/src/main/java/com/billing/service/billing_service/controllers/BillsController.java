package com.billing.service.billing_service.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.services.IBillsService;

@Controller
@RequestMapping("bills")
public class BillsController {
    @Autowired
    private IBillsService service;

    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    @ResponseBody
    public Map listBills() {
        return Collections.singletonMap("bills", service.getBills());
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    @ResponseBody
    public Map createBill(@RequestBody @Validated Bills bill) {
        service.saveBill(bill);
        return listBills();
    }
}
