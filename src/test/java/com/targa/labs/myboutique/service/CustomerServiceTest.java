package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Customer;
import com.targa.labs.myboutique.repository.CustomerRepository;
import com.targa.labs.myboutique.web.dto.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        CustomerDto customerDto = new CustomerDto(null, "John", "Doe", "john.doe@example.com", "123456789");
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);
        Customer savedCustomer = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDto result = customerService.create(customerDto);

        assertNotNull(result);
        assertEquals(savedCustomer.getId(), result.getId());
        assertEquals(savedCustomer.getFirstName(), result.getFirstName());
        assertEquals(savedCustomer.getLastName(), result.getLastName());
        assertEquals(savedCustomer.getEmail(), result.getEmail());
        assertEquals(savedCustomer.getTelephone(), result.getTelephone());
    }

    @Test
    public void testFindAll() {
        Customer customer1 = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);
        Customer customer2 = new Customer(2L, "Jane", "Doe", "jane.doe@example.com", "987654321", Collections.emptySet(), true);

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<CustomerDto> result = customerService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Customer customer = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        CustomerDto result = customerService.findById(1L);

        assertNotNull(result);
        assertEquals(customer.getId(), result.getId());
        assertEquals(customer.getFirstName(), result.getFirstName());
        assertEquals(customer.getLastName(), result.getLastName());
        assertEquals(customer.getEmail(), result.getEmail());
        assertEquals(customer.getTelephone(), result.getTelephone());
    }

    @Test
    public void testFindAllActive() {
        Customer customer1 = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);
        Customer customer2 = new Customer(2L, "Jane", "Doe", "jane.doe@example.com", "987654321", Collections.emptySet(), true);

        when(customerRepository.findAllByEnabled(true)).thenReturn(Arrays.asList(customer1, customer2));

        List<CustomerDto> result = customerService.findAllActive();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindAllInactive() {
        Customer customer1 = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), false);
        Customer customer2 = new Customer(2L, "Jane", "Doe", "jane.doe@example.com", "987654321", Collections.emptySet(), false);

        when(customerRepository.findAllByEnabled(false)).thenReturn(Arrays.asList(customer1, customer2));

        List<CustomerDto> result = customerService.findAllInactive();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testDelete() {
        Customer customer = new Customer(1L, "John", "Doe", "john.doe@example.com", "123456789", Collections.emptySet(), true);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        customerService.delete(1L);

        assertFalse(customer.getEnabled());
        verify(customerRepository, times(1)).save(customer);
    }
}
