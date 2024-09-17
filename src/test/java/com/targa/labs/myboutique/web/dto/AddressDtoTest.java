package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressDtoTest {

    @Test
    public void testAllArgsConstructor() {
        AddressDto addressDto = new AddressDto("123 Main St", "Apt 4", "Springfield", "12345", "USA");
        assertEquals("123 Main St", addressDto.getAddress1());
        assertEquals("Apt 4", addressDto.getAddress2());
        assertEquals("Springfield", addressDto.getCity());
        assertEquals("12345", addressDto.getPostcode());
        assertEquals("USA", addressDto.getCountry());
    }

    @Test
    public void testNoArgsConstructor() {
        AddressDto addressDto = new AddressDto();
        assertNull(addressDto.getAddress1());
        assertNull(addressDto.getAddress2());
        assertNull(addressDto.getCity());
        assertNull(addressDto.getPostcode());
        assertNull(addressDto.getCountry());
    }

    @Test
    public void testSettersAndGetters() {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress1("123 Main St");
        addressDto.setAddress2("Apt 4");
        addressDto.setCity("Springfield");
        addressDto.setPostcode("12345");
        addressDto.setCountry("USA");

        assertEquals("123 Main St", addressDto.getAddress1());
        assertEquals("Apt 4", addressDto.getAddress2());
        assertEquals("Springfield", addressDto.getCity());
        assertEquals("12345", addressDto.getPostcode());
        assertEquals("USA", addressDto.getCountry());
    }
}
