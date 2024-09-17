package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.CartService;
import com.targa.labs.myboutique.web.dto.CartDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CartResourceTest {

    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartResource cartResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(cartResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        CartDto cartDto = new CartDto(1L, 1L, "NEW");
        List<CartDto> cartDtoList = Collections.singletonList(cartDto);

        when(cartService.findAll()).thenReturn(cartDtoList);

        mockMvc.perform(get("/api/carts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(cartDto.getId()))
                .andExpect(jsonPath("$[0].customerId").value(cartDto.getCustomerId()))
                .andExpect(jsonPath("$[0].status").value(cartDto.getStatus()));
    }

    @Test
    public void testFindAllActiveCarts() throws Exception {
        CartDto cartDto = new CartDto(1L, 1L, "NEW");
        List<CartDto> cartDtoList = Collections.singletonList(cartDto);

        when(cartService.findAllActiveCarts()).thenReturn(cartDtoList);

        mockMvc.perform(get("/api/carts/active"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(cartDto.getId()))
                .andExpect(jsonPath("$[0].customerId").value(cartDto.getCustomerId()))
                .andExpect(jsonPath("$[0].status").value(cartDto.getStatus()));
    }

    @Test
    public void testGetActiveCartForCustomer() throws Exception {
        CartDto cartDto = new CartDto(1L, 1L, "NEW");

        when(cartService.getActiveCart(anyLong())).thenReturn(cartDto);

        mockMvc.perform(get("/api/carts/customer/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(cartDto.getId()))
                .andExpect(jsonPath("$.customerId").value(cartDto.getCustomerId()))
                .andExpect(jsonPath("$.status").value(cartDto.getStatus()));
    }

    @Test
    public void testFindById() throws Exception {
        CartDto cartDto = new CartDto(1L, 1L, "NEW");

        when(cartService.findById(anyLong())).thenReturn(cartDto);

        mockMvc.perform(get("/api/carts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(cartDto.getId()))
                .andExpect(jsonPath("$.customerId").value(cartDto.getCustomerId()))
                .andExpect(jsonPath("$.status").value(cartDto.getStatus()));
    }

    @Test
    public void testCreate() throws Exception {
        CartDto cartDto = new CartDto(1L, 1L, "NEW");

        when(cartService.createDto(anyLong())).thenReturn(cartDto);

        mockMvc.perform(post("/api/carts/customer/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(cartDto.getId()))
                .andExpect(jsonPath("$.customerId").value(cartDto.getCustomerId()))
                .andExpect(jsonPath("$.status").value(cartDto.getStatus()));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/carts/1"))
                .andExpect(status().isOk());
    }
}
