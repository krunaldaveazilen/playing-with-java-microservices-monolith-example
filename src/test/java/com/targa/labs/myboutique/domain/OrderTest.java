package com.targa.labs.myboutique.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderConstructorAndGetters() {
        BigDecimal totalPrice = new BigDecimal("100.00");
        OrderStatus status = OrderStatus.PAID;
        ZonedDateTime shipped = ZonedDateTime.now();
        Payment payment = new Payment();
        Address shipmentAddress = new Address();
        Set<OrderItem> orderItems = new HashSet<>();
        Cart cart = new Cart();

        Order order = new Order(totalPrice, status, shipped, payment, shipmentAddress, orderItems, cart);

        assertEquals(totalPrice, order.getTotalPrice());
        assertEquals(status, order.getStatus());
        assertEquals(shipped, order.getShipped());
        assertEquals(payment, order.getPayment());
        assertEquals(shipmentAddress, order.getShipmentAddress());
        assertEquals(orderItems, order.getOrderItems());
        assertEquals(cart, order.getCart());
    }

    @Test
    public void testEqualsAndHashCode() {
        BigDecimal totalPrice = new BigDecimal("100.00");
        OrderStatus status = OrderStatus.PAID;
        ZonedDateTime shipped = ZonedDateTime.now();
        Payment payment = new Payment();
        Address shipmentAddress = new Address();
        Set<OrderItem> orderItems = new HashSet<>();
        Cart cart = new Cart();

        Order order1 = new Order(totalPrice, status, shipped, payment, shipmentAddress, orderItems, cart);
        Order order2 = new Order(totalPrice, status, shipped, payment, shipmentAddress, orderItems, cart);

        assertEquals(order1, order2);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void testToString() {
        BigDecimal totalPrice = new BigDecimal("100.00");
        OrderStatus status = OrderStatus.PAID;
        ZonedDateTime shipped = ZonedDateTime.now();
        Payment payment = new Payment();
        Address shipmentAddress = new Address();
        Set<OrderItem> orderItems = new HashSet<>();
        Cart cart = new Cart();
        cart.setId(1L);

        Order order = new Order(totalPrice, status, shipped, payment, shipmentAddress, orderItems, cart);

        String expected = "Order{totalPrice=100.00, status=PAID, shipped=" + shipped + ", payment=" + payment + ", shipmentAddress=" + shipmentAddress + ", cart=1}";
        assertEquals(expected, order.toString());
    }
}
