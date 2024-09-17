package com.targa.labs.myboutique.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.targa.labs.myboutique.domain.enumeration.PaymentStatus;

public class PaymentTest {

    @Test
    public void testEquals() {
        Payment payment1 = new Payment("123", PaymentStatus.COMPLETED, new Order());
        Payment payment2 = new Payment("123", PaymentStatus.PENDING, new Order());
        Payment payment3 = new Payment("456", PaymentStatus.COMPLETED, new Order());

        assertEquals(payment1, payment2);
        assertNotEquals(payment1, payment3);
    }

    @Test
    public void testHashCode() {
        Payment payment1 = new Payment("123", PaymentStatus.COMPLETED, new Order());
        Payment payment2 = new Payment("123", PaymentStatus.PENDING, new Order());

        assertEquals(payment1.hashCode(), payment2.hashCode());
    }

    @Test
    public void testToString() {
        Order order = new Order();
        order.setId(1L);
        Payment payment = new Payment("123", PaymentStatus.COMPLETED, order);

        String expected = "Payment{paypalPaymentId='123', status=COMPLETED, order=1}";
        assertEquals(expected, payment.toString());
    }
}
