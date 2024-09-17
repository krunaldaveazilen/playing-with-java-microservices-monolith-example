package com.targa.labs.myboutique.domain.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductStatusTest {

    @Test
    public void testProductStatusValues() {
        ProductStatus[] statuses = ProductStatus.values();
        assertEquals(2, statuses.length);
        assertEquals(ProductStatus.AVAILABLE, statuses[0]);
        assertEquals(ProductStatus.DISCONTINUED, statuses[1]);
    }

    @Test
    public void testValueOf() {
        assertEquals(ProductStatus.AVAILABLE, ProductStatus.valueOf("AVAILABLE"));
        assertEquals(ProductStatus.DISCONTINUED, ProductStatus.valueOf("DISCONTINUED"));
    }
}
