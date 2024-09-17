package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartDtoTest {

    @Test
    public void testNoArgsConstructor() {
        CartDto cartDto = new CartDto();
        assertNotNull(cartDto);
    }

    @Test
    public void testAllArgsConstructor() {
        CartDto cartDto = new CartDto(1L, 2L, "ACTIVE");
        assertEquals(1L, cartDto.getId());
        assertEquals(2L, cartDto.getCustomerId());
        assertEquals("ACTIVE", cartDto.getStatus());
    }

    @Test
    public void testSettersAndGetters() {
        CartDto cartDto = new CartDto();
        cartDto.setId(1L);
        cartDto.setCustomerId(2L);
        cartDto.setStatus("ACTIVE");

        assertEquals(1L, cartDto.getId());
        assertEquals(2L, cartDto.getCustomerId());
        assertEquals("ACTIVE", cartDto.getStatus());
    }

    @Test
    public void testEqualsAndHashCode() {
        CartDto cartDto1 = new CartDto(1L, 2L, "ACTIVE");
        CartDto cartDto2 = new CartDto(1L, 2L, "ACTIVE");

        assertEquals(cartDto1, cartDto2);
        assertEquals(cartDto1.hashCode(), cartDto2.hashCode());
    }

    @Test
    public void testToString() {
        CartDto cartDto = new CartDto(1L, 2L, "ACTIVE");
        String expected = "CartDto(id=1, customerId=2, status=ACTIVE)";
        assertEquals(expected, cartDto.toString());
    }
}
