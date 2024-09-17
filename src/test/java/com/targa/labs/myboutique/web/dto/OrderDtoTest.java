package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderDtoTest {

    @Test
    public void testNoArgsConstructor() {
        OrderDto orderDto = new OrderDto();
        assertNotNull(orderDto);
    }

    @Test
    public void testAllArgsConstructor() {
        AddressDto addressDto = new AddressDto("123 Main St", "Apt 4", "Springfield", "12345", "USA");
        Set<OrderItemDto> orderItems = new HashSet<>();
        orderItems.add(new OrderItemDto(1L, 2L, 3L, 4L));

        OrderDto orderDto = new OrderDto(1L, new BigDecimal("99.99"), "SHIPPED", ZonedDateTime.now(), 2L, addressDto, orderItems);

        assertEquals(1L, orderDto.getId());
        assertEquals(new BigDecimal("99.99"), orderDto.getTotalPrice());
        assertEquals("SHIPPED", orderDto.getStatus());
        assertNotNull(orderDto.getShipped());
        assertEquals(2L, orderDto.getPaymentId());
        assertEquals(addressDto, orderDto.getShipmentAddress());
        assertEquals(orderItems, orderDto.getOrderItems());
    }

    @Test
    public void testSettersAndGetters() {
        OrderDto orderDto = new OrderDto();
        AddressDto addressDto = new AddressDto("123 Main St", "Apt 4", "Springfield", "12345", "USA");
        Set<OrderItemDto> orderItems = new HashSet<>();
        orderItems.add(new OrderItemDto(1L, 2L, 3L, 4L));

        orderDto.setId(1L);
        orderDto.setTotalPrice(new BigDecimal("99.99"));
        orderDto.setStatus("SHIPPED");
        orderDto.setShipped(ZonedDateTime.now());
        orderDto.setPaymentId(2L);
        orderDto.setShipmentAddress(addressDto);
        orderDto.setOrderItems(orderItems);

        assertEquals(1L, orderDto.getId());
        assertEquals(new BigDecimal("99.99"), orderDto.getTotalPrice());
        assertEquals("SHIPPED", orderDto.getStatus());
        assertNotNull(orderDto.getShipped());
        assertEquals(2L, orderDto.getPaymentId());
        assertEquals(addressDto, orderDto.getShipmentAddress());
        assertEquals(orderItems, orderDto.getOrderItems());
    }
}
