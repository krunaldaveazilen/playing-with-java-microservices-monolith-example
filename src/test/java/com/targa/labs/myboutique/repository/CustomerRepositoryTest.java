package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testFindAllByEnabled() {
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        Customer customer2 = new Customer("Jane", "Doe", "jane.doe@example.com", "0987654321", null, true);

        when(customerRepository.findAllByEnabled(true)).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> customers = customerRepository.findAllByEnabled(true);

        assertThat(customers).hasSize(2);
        assertThat(customers).contains(customer1, customer2);
    }
}
