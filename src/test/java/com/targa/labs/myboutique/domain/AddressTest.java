package com.targa.labs.myboutique.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testEquals() {
        Address address1 = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        Address address2 = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        Address address3 = new Address("456 Elm St", "Apt 5", "Shelbyville", "67890", "US");

        assertEquals(address1, address2);
        assertNotEquals(address1, address3);
    }

    @Test
    public void testHashCode() {
        Address address1 = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        Address address2 = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        Address address3 = new Address("456 Elm St", "Apt 5", "Shelbyville", "67890", "US");

        assertEquals(address1.hashCode(), address2.hashCode());
        assertNotEquals(address1.hashCode(), address3.hashCode());
    }

    @Test
    public void testToString() {
        Address address = new Address("123 Main St", "Apt 4", "Springfield", "12345", "US");
        String expected = "Address{address1='123 Main St', address2='Apt 4', city='Springfield', postcode='12345', country='US'}";
        assertEquals(expected, address.toString());
    }
}
