package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.ProductService;
import com.targa.labs.myboutique.web.dto.ProductDto;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductResourceTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductResource productResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        ProductDto productDto = new ProductDto();
        List<ProductDto> allProducts = Collections.singletonList(productDto);

        when(productService.findAll()).thenReturn(allProducts);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists());

        verify(productService, times(1)).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        ProductDto productDto = new ProductDto();

        when(productService.findById(anyLong())).thenReturn(productDto);

        mockMvc.perform(get("/api/products/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(productService, times(1)).findById(1L);
    }

    @Test
    public void testCreate() throws Exception {
        ProductDto productDto = new ProductDto();

        when(productService.create(any(ProductDto.class))).thenReturn(productDto);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test Product\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());

        verify(productService, times(1)).create(any(ProductDto.class));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(productService).delete(anyLong());

        mockMvc.perform(delete("/api/products/{id}", 1L))
                .andExpect(status().isOk());

        verify(productService, times(1)).delete(1L);
    }
}
