package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.OrderItemService;
import com.targa.labs.myboutique.web.dto.OrderItemDto;
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

public class OrderItemResourceTest {

    private MockMvc mockMvc;

    @Mock
    private OrderItemService itemService;

    @InjectMocks
    private OrderItemResource orderItemResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderItemResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        OrderItemDto orderItemDto1 = new OrderItemDto();
        OrderItemDto orderItemDto2 = new OrderItemDto();
        List<OrderItemDto> orderItemDtos = Arrays.asList(orderItemDto1, orderItemDto2);

        when(itemService.findAll()).thenReturn(orderItemDtos);

        mockMvc.perform(get("/api/order-items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists());
    }

    @Test
    public void testFindById() throws Exception {
        OrderItemDto orderItemDto = new OrderItemDto();
        when(itemService.findById(anyLong())).thenReturn(orderItemDto);

        mockMvc.perform(get("/api/order-items/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testCreate() throws Exception {
        OrderItemDto orderItemDto = new OrderItemDto();
        when(itemService.create(any(OrderItemDto.class))).thenReturn(orderItemDto);

        mockMvc.perform(post("/api/order-items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test Item\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/order-items/1"))
                .andExpect(status().isOk());
    }
}
