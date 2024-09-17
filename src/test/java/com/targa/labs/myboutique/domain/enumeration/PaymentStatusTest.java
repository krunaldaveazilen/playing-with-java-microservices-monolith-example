package com.targa.labs.myboutique.domain.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentStatusTest {

    @Test
    public void testPaymentStatusValues() {
        PaymentStatus[] statuses = PaymentStatus.values();
        assertEquals(4, statuses.length);
        assertEquals(PaymentStatus.ACCEPTED, statuses[0]);
        assertEquals(PaymentStatus.PENDING, statuses[1]);
        assertEquals(PaymentStatus.REFUSED, statuses[2]);
        assertEquals(PaymentStatus.ERROR, statuses[3]);
    }

    @Test
    public void testValueOf() {
        assertEquals(PaymentStatus.ACCEPTED, PaymentStatus.valueOf("ACCEPTED"));
        assertEquals(PaymentStatus.PENDING, PaymentStatus.valueOf("PENDING"));
        assertEquals(PaymentStatus.REFUSED, PaymentStatus.valueOf("REFUSED"));
        assertEquals(PaymentStatus.ERROR, PaymentStatus.valueOf("ERROR"));
    }
}
