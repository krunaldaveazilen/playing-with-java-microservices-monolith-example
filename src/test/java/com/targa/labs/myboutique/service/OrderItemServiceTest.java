package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Order;
import com.targa.labs.myboutique.domain.OrderItem;
import com.targa.labs.myboutique.domain.Product;
import com.targa.labs.myboutique.repository.OrderItemRepository;
import com.targa.labs.myboutique.repository.OrderRepository;
import com.targa.labs.myboutique.repository.ProductRepository;
import com.targa.labs.myboutique.web.dto.OrderItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderItemService orderItemService;

    private OrderItem orderItem;
    private OrderItemDto orderItemDto;
    private Order order;
    private Product product;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setId(1L);
        order.setTotalPrice(BigDecimal.ZERO);

        product = new Product();
        product.setId(1L);
        product.setPrice(BigDecimal.TEN);

        orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setQuantity(1);
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        orderItemDto = new OrderItemDto(1L, 1, 1L, 1L);
    }

    @Test
    void testFindAll() {
        when(orderItemRepository.findAll()).thenReturn(Arrays.asList(orderItem));

        List<OrderItemDto> result = orderItemService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(orderItemDto.getId(), result.get(0).getId());
    }

    @Test
    void testFindById() {
        when(orderItemRepository.findById(1L)).thenReturn(Optional.of(orderItem));

        OrderItemDto result = orderItemService.findById(1L);

        assertNotNull(result);
        assertEquals(orderItemDto.getId(), result.getId());
    }

    @Test
    void testCreate() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderItemDto result = orderItemService.create(orderItemDto);

        assertNotNull(result);
        assertEquals(orderItemDto.getId(), result.getId());
        assertEquals(orderItemDto.getQuantity(), result.getQuantity());
        assertEquals(orderItemDto.getProductId(), result.getProductId());
        assertEquals(orderItemDto.getOrderId(), result.getOrderId());
    }

    @Test
    void testDelete() {
        doNothing().when(orderItemRepository).deleteById(1L);

        orderItemService.delete(1L);

        verify(orderItemRepository, times(1)).deleteById(1L);
    }
}
