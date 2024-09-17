package com.targa.labs.myboutique.domain.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderStatusTest {

    @Test
    public void testOrderStatusValues() {
        OrderStatus[] statuses = OrderStatus.values();
        assertEquals(6, statuses.length);
        assertEquals(OrderStatus.CREATION, statuses[0]);
        assertEquals(OrderStatus.NEW, statuses[1]);
        assertEquals(OrderStatus.HOLD, statuses[2]);
        assertEquals(OrderStatus.SHIPPED, statuses[3]);
        assertEquals(OrderStatus.DELIVERED, statuses[4]);
        assertEquals(OrderStatus.CLOSED, statuses[5]);
    }

    @Test
    public void testOrderStatusValueOf() {
        assertEquals(OrderStatus.CREATION, OrderStatus.valueOf("CREATION"));
        assertEquals(OrderStatus.NEW, OrderStatus.valueOf("NEW"));
        assertEquals(OrderStatus.HOLD, OrderStatus.valueOf("HOLD"));
        assertEquals(OrderStatus.SHIPPED, OrderStatus.valueOf("SHIPPED"));
        assertEquals(OrderStatus.DELIVERED, OrderStatus.valueOf("DELIVERED"));
        assertEquals(OrderStatus.CLOSED, OrderStatus.valueOf("CLOSED"));
    }
}
