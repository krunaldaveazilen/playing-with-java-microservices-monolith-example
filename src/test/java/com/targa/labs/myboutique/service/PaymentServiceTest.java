package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Order;
import com.targa.labs.myboutique.domain.Payment;
import com.targa.labs.myboutique.domain.enumeration.PaymentStatus;
import com.targa.labs.myboutique.repository.OrderRepository;
import com.targa.labs.myboutique.repository.PaymentRepository;
import com.targa.labs.myboutique.web.dto.PaymentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentService paymentService;

    private Payment payment;
    private Order order;
    private PaymentDto paymentDto;

    @BeforeEach
    public void setUp() {
        order = new Order();
        order.setId(1L);

        payment = new Payment();
        payment.setId(1L);
        payment.setPaypalPaymentId("PAYPAL123");
        payment.setStatus(PaymentStatus.COMPLETED);
        payment.setOrder(order);

        paymentDto = new PaymentDto(1L, "PAYPAL123", "COMPLETED", 1L);
    }

    @Test
    public void testFindAll() {
        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment));

        List<PaymentDto> result = paymentService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(paymentDto, result.get(0));
    }

    @Test
    public void testFindById() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

        PaymentDto result = paymentService.findById(1L);

        assertNotNull(result);
        assertEquals(paymentDto, result);
    }

    @Test
    public void testCreate() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDto result = paymentService.create(paymentDto);

        assertNotNull(result);
        assertEquals(paymentDto, result);
    }

    @Test
    public void testDelete() {
        doNothing().when(paymentRepository).deleteById(1L);

        paymentService.delete(1L);

        verify(paymentRepository, times(1)).deleteById(1L);
    }
}
