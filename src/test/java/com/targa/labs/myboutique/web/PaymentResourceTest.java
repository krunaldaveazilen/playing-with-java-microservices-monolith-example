package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.PaymentService;
import com.targa.labs.myboutique.web.dto.PaymentDto;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PaymentResourceTest {

    private MockMvc mockMvc;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentResource paymentResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(paymentResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        PaymentDto paymentDto1 = new PaymentDto();
        PaymentDto paymentDto2 = new PaymentDto();
        List<PaymentDto> paymentDtos = Arrays.asList(paymentDto1, paymentDto2);

        when(paymentService.findAll()).thenReturn(paymentDtos);

        mockMvc.perform(get("/api/payments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(paymentDtos.size()));
    }

    @Test
    public void testFindById() throws Exception {
        PaymentDto paymentDto = new PaymentDto();
        when(paymentService.findById(anyLong())).thenReturn(paymentDto);

        mockMvc.perform(get("/api/payments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreate() throws Exception {
        PaymentDto paymentDto = new PaymentDto();
        when(paymentService.create(any(PaymentDto.class))).thenReturn(paymentDto);

        mockMvc.perform(post("/api/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/payments/1"))
                .andExpect(status().isOk());
    }
}
