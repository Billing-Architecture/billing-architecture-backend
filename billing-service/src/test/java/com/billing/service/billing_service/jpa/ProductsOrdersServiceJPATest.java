package com.billing.service.billing_service.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.billing.service.billing_service.domain.Orders;
import com.billing.service.billing_service.domain.Products;
import com.billing.service.billing_service.domain.ProductsOrders;
import com.billing.service.billing_service.repositorys.OrdersRepository;
import com.billing.service.billing_service.repositorys.ProductsOrdersRepository;

@ExtendWith(MockitoExtension.class)
public class ProductsOrdersServiceJPATest {

    @Mock
    private ProductsOrdersRepository repositoryDetails;

    @Mock
    private OrdersRepository repositoryOrder;

    @InjectMocks
    private ProductsOrdersServiceJPA service;

    @Test
    void shouldSaveProductsOrdersAndCalculateTotals() {
        /* 
        Products product = new Products();
        product.setProductDefaultPrice(100);
        product.setProductTaxPercentage(0.13);
        product.setProductDescountPercentage(0.10);

        ProductsOrders detail = new ProductsOrders();
        detail.setProduct(product);
        detail.setProductsOrdersQuantity(2);

        ProductsOrders[] details = { detail };

        when(repositoryOrder.save(any(Orders.class))).thenAnswer(invocation -> invocation.getArgument(0));

        service.saveProductsOrders(details);
        
        assertNotNull(detail.getOrder());
        assertEquals(200, detail.getProductsOrdersSubtotal());
        assertEquals(20, detail.getProduct().getProductDescountPercentage() * 100 * 2 / 0.10 * 0.10, 0.01);
        assertEquals((200 - 20) + 26, detail.getProductsOrdersTotal(), 0.01);

        verify(repositoryOrder).save(any(Orders.class));
        */
        
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
