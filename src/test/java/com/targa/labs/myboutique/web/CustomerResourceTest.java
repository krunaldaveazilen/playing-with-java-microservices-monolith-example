package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.CustomerService;
import com.targa.labs.myboutique.web.dto.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CustomerResourceTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerResource customerResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        List<CustomerDto> customers = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(customers.size()));

        verify(customerService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        CustomerDto customer = new CustomerDto();
        when(customerService.findById(anyLong())).thenReturn(customer);

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(customer.getId()));

        verify(customerService, times(1)).findById(anyLong());
    }

    @Test
    public void testFindAllActive() throws Exception {
        List<CustomerDto> customers = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerService.findAllActive()).thenReturn(customers);

        mockMvc.perform(get("/api/customers/active"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(customers.size()));

        verify(customerService, times(1)).findAllActive();
    }

    @Test
    public void testFindAllInactive() throws Exception {
        List<CustomerDto> customers = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerService.findAllInactive()).thenReturn(customers);

        mockMvc.perform(get("/api/customers/inactive"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(customers.size()));

        verify(customerService, times(1)).findAllInactive();
    }

    @Test
    public void testCreate() throws Exception {
        CustomerDto customer = new CustomerDto();
        when(customerService.create(any(CustomerDto.class))).thenReturn(customer);

        mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(customer.getId()));

        verify(customerService, times(1)).create(any(CustomerDto.class));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(customerService).delete(anyLong());

        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isOk());

        verify(customerService, times(1)).delete(anyLong());
    }
}
