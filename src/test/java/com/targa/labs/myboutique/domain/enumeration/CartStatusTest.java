package com.targa.labs.myboutique.domain.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartStatusTest {

    @Test
    public void testCartStatusValues() {
        CartStatus[] statuses = CartStatus.values();
        assertEquals(3, statuses.length);
        assertEquals(CartStatus.NEW, statuses[0]);
        assertEquals(CartStatus.CANCELED, statuses[1]);
        assertEquals(CartStatus.CONFIRMED, statuses[2]);
    }

    @Test
    public void testValueOf() {
        assertEquals(CartStatus.NEW, CartStatus.valueOf("NEW"));
        assertEquals(CartStatus.CANCELED, CartStatus.valueOf("CANCELED"));
        assertEquals(CartStatus.CONFIRMED, CartStatus.valueOf("CONFIRMED"));
    }
}
