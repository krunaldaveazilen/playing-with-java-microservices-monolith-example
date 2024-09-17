package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentDtoTest {

    @Test
    public void testAllArgsConstructor() {
        PaymentDto paymentDto = new PaymentDto(1L, "paypal123", "COMPLETED", 100L);
        assertEquals(1L, paymentDto.getId());
        assertEquals("paypal123", paymentDto.getPaypalPaymentId());
        assertEquals("COMPLETED", paymentDto.getStatus());
        assertEquals(100L, paymentDto.getOrderId());
    }

    @Test
    public void testNoArgsConstructor() {
        PaymentDto paymentDto = new PaymentDto();
        assertNull(paymentDto.getId());
        assertNull(paymentDto.getPaypalPaymentId());
        assertNull(paymentDto.getStatus());
        assertNull(paymentDto.getOrderId());
    }

    @Test
    public void testSettersAndGetters() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(1L);
        paymentDto.setPaypalPaymentId("paypal123");
        paymentDto.setStatus("COMPLETED");
        paymentDto.setOrderId(100L);

        assertEquals(1L, paymentDto.getId());
        assertEquals("paypal123", paymentDto.getPaypalPaymentId());
        assertEquals("COMPLETED", paymentDto.getStatus());
        assertEquals(100L, paymentDto.getOrderId());
    }

    @Test
    public void testEqualsAndHashCode() {
        PaymentDto paymentDto1 = new PaymentDto(1L, "paypal123", "COMPLETED", 100L);
        PaymentDto paymentDto2 = new PaymentDto(1L, "paypal123", "COMPLETED", 100L);
        PaymentDto paymentDto3 = new PaymentDto(2L, "paypal456", "PENDING", 101L);

        assertEquals(paymentDto1, paymentDto2);
        assertNotEquals(paymentDto1, paymentDto3);
        assertEquals(paymentDto1.hashCode(), paymentDto2.hashCode());
        assertNotEquals(paymentDto1.hashCode(), paymentDto3.hashCode());
    }

    @Test
    public void testToString() {
        PaymentDto paymentDto = new PaymentDto(1L, "paypal123", "COMPLETED", 100L);
        String expectedString = "PaymentDto(id=1, paypalPaymentId=paypal123, status=COMPLETED, orderId=100)";
        assertEquals(expectedString, paymentDto.toString());
    }
}
