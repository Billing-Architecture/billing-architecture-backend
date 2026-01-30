package com.billing.service.billing_service.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.repositorys.ProductsRepository;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceJPATest {
    
    @Mock
    private ProductsRepository repository;

    @InjectMocks
    private ProductsServiceJPA serviceJPA; 

    @Test
    void shouldSaveProduct () {
        Products product = new Products();
        product.setProductCode("P-9999");
        product.setProductName("Product");
        product.setProductTaxPercentage(0.99);
        product.setProductDescountPercentage(0.99);
        product.setProductDefaultPrice(999);
        product.setProductCreatedAt(LocalDateTime.now());

        serviceJPA.saveProduct(product);
        verify(repository).save(product);
    }

    @Test
    void shouldDeleteProduct () {
        Long productId = 1L;
        serviceJPA.deleteProduct(productId);
        verify(repository).deleteById(productId);
    }

    @Test
    void shouldReturnProduct () {
        Long productId = 1L;

        Products product = new Products();
        product.setProductId(productId);
        product.setProductName("Product");

        when(repository.findById(productId)).thenReturn(Optional.of(product));

        Products result = serviceJPA.byId(productId);

        assertEquals("Product", result.getProductName());
        verify(repository).findById(productId);
    }
}
