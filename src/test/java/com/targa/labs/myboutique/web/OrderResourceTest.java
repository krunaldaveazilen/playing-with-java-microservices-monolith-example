package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.OrderService;
import com.targa.labs.myboutique.web.dto.OrderDto;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class OrderResourceTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderResource orderResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        List<OrderDto> orders = Arrays.asList(new OrderDto(), new OrderDto());
        when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/api/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(orderService, times(1)).findAll();
    }

    @Test
    public void testFindAllByUser() throws Exception {
        Long userId = 1L;
        List<OrderDto> orders = Arrays.asList(new OrderDto(), new OrderDto());
        when(orderService.findAllByUser(userId)).thenReturn(orders);

        mockMvc.perform(get("/api/orders/customer/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(orderService, times(1)).findAllByUser(userId);
    }

    @Test
    public void testFindById() throws Exception {
        Long orderId = 1L;
        OrderDto order = new OrderDto();
        when(orderService.findById(orderId)).thenReturn(order);

        mockMvc.perform(get("/api/orders/{id}", orderId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).findById(orderId);
    }

    @Test
    public void testDelete() throws Exception {
        Long orderId = 1L;
        doNothing().when(orderService).delete(orderId);

        mockMvc.perform(delete("/api/orders/{id}", orderId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).delete(orderId);
    }
}
