package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerDtoTest {

    @Test
    public void testNoArgsConstructor() {
        CustomerDto customer = new CustomerDto();
        assertNull(customer.getId());
        assertNull(customer.getFirstName());
        assertNull(customer.getLastName());
        assertNull(customer.getEmail());
        assertNull(customer.getTelephone());
    }

    @Test
    public void testAllArgsConstructor() {
        CustomerDto customer = new CustomerDto(1L, "John", "Doe", "john.doe@example.com", "1234567890");
        assertEquals(1L, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getTelephone());
    }

    @Test
    public void testSettersAndGetters() {
        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setTelephone("1234567890");

        assertEquals(1L, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getTelephone());
    }

    @Test
    public void testEqualsAndHashCode() {
        CustomerDto customer1 = new CustomerDto(1L, "John", "Doe", "john.doe@example.com", "1234567890");
        CustomerDto customer2 = new CustomerDto(1L, "John", "Doe", "john.doe@example.com", "1234567890");

        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    @Test
    public void testToString() {
        CustomerDto customer = new CustomerDto(1L, "John", "Doe", "john.doe@example.com", "1234567890");
        String expected = "CustomerDto(id=1, firstName=John, lastName=Doe, email=john.doe@example.com, telephone=1234567890)";
        assertEquals(expected, customer.toString());
    }
}
