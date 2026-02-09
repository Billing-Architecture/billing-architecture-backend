package com.billing.service.billing_service.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.billing.service.billing_service.domain.Bills;
import com.billing.service.billing_service.domain.Orders;
import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.dtos.ProductOrderItemRequest;
import com.billing.service.billing_service.repositorys.BillsRepository;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.repositorys.ProductsOrdersRepository;
import com.billing.service.billing_service.repositorys.ProductsRepository;

@ExtendWith(MockitoExtension.class)
public class ProductsOrdersServiceJPATest {

    @Mock
    private ProductsOrdersRepository repositoryDetails;

    @Mock
    private OrdersRepository repositoryOrder;

    @Mock
    private ProductsRepository repositoryProduct;

    @Mock
    private BillsRepository repositoryBill;

    @InjectMocks
    private ProductsOrdersServiceJPA service;

    @Test
    void shouldSaveProductsOrdersAndCalculateTotals() {
        
        Products product = new Products();
        product.setProductId(1L);
        product.setProductDefaultPrice(100);
        product.setProductTaxPercentage(0.13);
        product.setProductDescountPercentage(0.10);

        ProductOrderItemRequest detail = new ProductOrderItemRequest();
        detail.setProductId(product.getProductId());
        detail.setQuantity(2);

        List<ProductOrderItemRequest> details = List.of(detail);

        when(repositoryProduct.findById(1L))
                .thenReturn(Optional.of(product));

        when(repositoryOrder.save(any(Orders.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        when(repositoryBill.save(any(Bills.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Bills result = service.saveProductsOrders(details);
        
        assertEquals(200, result.getBillSubtotal()); // 200 * 2
        assertEquals(206, result.getBillTotal(), 0.01); // (200 - 20) + 26

        verify(repositoryOrder).save(any(Orders.class));
        verify(repositoryBill).save(any(Bills.class));
    }

    @Test
    void shouldNotSaveProductsOrdersWhenProductNotFound() {
        Products product = new Products();
        product.setProductId(1L);
        product.setProductDefaultPrice(100);
        product.setProductTaxPercentage(0.13);
        product.setProductDescountPercentage(0.10);

        ProductOrderItemRequest detail = new ProductOrderItemRequest();
        detail.setProductId(product.getProductId());
        detail.setQuantity(2);

        List<ProductOrderItemRequest> details = List.of(detail);

        when(repositoryProduct.findById(1L))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, 
            () -> service.saveProductsOrders(details));
        assertEquals("Product not found", exception.getMessage());

        verify(repositoryOrder, never()).save(any());
        verify(repositoryBill, never()).save(any());
    }

    @Test
    void shouldReturnProductsOrders() {
        ProductsOrders detail = new ProductsOrders();
        when(repositoryDetails.findAll()).thenReturn(List.of(detail));

        List<ProductsOrders> result = service.getProductsOrders();

        assertEquals(1, result.size());
        verify(repositoryDetails).findAll();
    }

    @Test
    void shouldReturnDetailById() {
        Long id = 1L;
        ProductsOrders detail = new ProductsOrders();

        when(repositoryDetails.findById(id)).thenReturn(Optional.of(detail));

        ProductsOrders result = service.byId(id);

        assertNotNull(result);
        verify(repositoryDetails).findById(id);
    }

    @Test
    void shouldThrowExceptionWhenDetailNotFound() {
        Long id = 99L;

        when(repositoryDetails.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> service.byId(id)
        );

        assertEquals("Detail not found.", exception.getMessage());
        verify(repositoryDetails).findById(id);
    }
}
