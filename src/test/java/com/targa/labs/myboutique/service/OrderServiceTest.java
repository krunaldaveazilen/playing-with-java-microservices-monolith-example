package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Address;
import com.targa.labs.myboutique.domain.Cart;
import com.targa.labs.myboutique.domain.Order;
import com.targa.labs.myboutique.domain.enumeration.OrderStatus;
import com.targa.labs.myboutique.repository.OrderRepository;
import com.targa.labs.myboutique.web.dto.OrderDto;
import com.targa.labs.myboutique.web.dto.OrderItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Order order = new Order();
        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));

        List<OrderDto> result = orderService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        OrderDto result = orderService.findById(1L);

        assertNotNull(result);
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAllByUser() {
        Order order = new Order();
        when(orderRepository.findByCartCustomer_Id(1L)).thenReturn(Collections.singletonList(order));

        List<OrderDto> result = orderService.findAllByUser(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(orderRepository, times(1)).findByCartCustomer_Id(1L);
    }

    @Test
    void testCreateOrderDto() {
        OrderDto orderDto = new OrderDto();
        Order order = new Order(BigDecimal.ZERO, OrderStatus.CREATION, null, null, new Address(), Collections.emptySet(), null);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderDto result = orderService.create(orderDto);

        assertNotNull(result);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testCreateCartAndAddress() {
        Cart cart = new Cart();
        Address address = new Address();
        Order order = new Order(BigDecimal.ZERO, OrderStatus.CREATION, null, null, address, Collections.emptySet(), cart);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.create(cart, address);

        assertNotNull(result);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testDelete() {
        doNothing().when(orderRepository).deleteById(1L);

        orderService.delete(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }
}
