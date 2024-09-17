package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Address;
import com.targa.labs.myboutique.web.dto.AddressDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressServiceTest {

    @Test
    public void testMapToDto() {
        Address address = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        AddressDto addressDto = AddressService.mapToDto(address);

        assertNotNull(addressDto);
        assertEquals("123 Main St", addressDto.getAddress1());
        assertEquals("Apt 4", addressDto.getAddress2());
        assertEquals("Springfield", addressDto.getCity());
        assertEquals("12345", addressDto.getPostcode());
        assertEquals("US", addressDto.getCountry());
    }

    @Test
    public void testMapToDto_Null() {
        AddressDto addressDto = AddressService.mapToDto(null);
        assertNull(addressDto);
    }

    @Test
    public void testCreateFromDto() {
        AddressDto addressDto = new AddressDto("123 Main St", "Apt 4", "Springfield", "12345", "US");
        Address address = AddressService.createFromDto(addressDto);

        assertNotNull(address);
        assertEquals("123 Main St", address.getAddress1());
        assertEquals("Apt 4", address.getAddress2());
        assertEquals("Springfield", address.getCity());
        assertEquals("12345", address.getPostcode());
        assertEquals("US", address.getCountry());
    }

    @Test
    public void testCreateFromDto_Null() {
        Address address = AddressService.createFromDto(null);
        assertNull(address);
    }
}
