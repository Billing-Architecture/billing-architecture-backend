package com.billing.service.billing_service.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.services.IProductService;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private IProductService service;
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/list")
    @ResponseBody
    public Map listProducts() {
        return Collections.singletonMap("products", service.getProducts());
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Products getProduct(@PathVariable("id") Long id) {
        return service.byId(id);
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    @ResponseBody
    public Map createProducts(@RequestBody @Validated Products product) {
        service.saveProduct(product);
        return listProducts();
    }

    @SuppressWarnings("rawtypes")
    @PutMapping("/edit")
    @ResponseBody
    public Map editProducts(@RequestBody @Validated Products product) {
        service.saveProduct(product);
        return listProducts();
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return listProducts();
    }
}
