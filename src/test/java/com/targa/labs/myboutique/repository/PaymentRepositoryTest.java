package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testSaveAndFindById() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setStatus("COMPLETED");

        Payment savedPayment = paymentRepository.save(payment);
        Optional<Payment> foundPayment = paymentRepository.findById(savedPayment.getId());

        assertThat(foundPayment).isPresent();
        assertThat(foundPayment.get().getAmount()).isEqualTo(100.0);
        assertThat(foundPayment.get().getStatus()).isEqualTo("COMPLETED");
    }

    @Test
    public void testDelete() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setStatus("COMPLETED");

        Payment savedPayment = paymentRepository.save(payment);
        paymentRepository.deleteById(savedPayment.getId());

        Optional<Payment> foundPayment = paymentRepository.findById(savedPayment.getId());
        assertThat(foundPayment).isNotPresent();
    }
}
