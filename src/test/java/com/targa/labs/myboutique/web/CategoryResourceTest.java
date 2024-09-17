package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.CategoryService;
import com.targa.labs.myboutique.web.dto.CategoryDto;
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

public class CategoryResourceTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryResource categoryResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(categoryResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        CategoryDto category1 = new CategoryDto(1L, "Category 1", "Description 1");
        CategoryDto category2 = new CategoryDto(2L, "Category 2", "Description 2");
        List<CategoryDto> categories = Arrays.asList(category1, category2);

        when(categoryService.findAll()).thenReturn(categories);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Category 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Category 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"));
    }

    @Test
    public void testFindById() throws Exception {
        CategoryDto category = new CategoryDto(1L, "Category 1", "Description 1");

        when(categoryService.findById(anyLong())).thenReturn(category);

        mockMvc.perform(get("/api/categories/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Category 1"))
                .andExpect(jsonPath("$.description").value("Description 1"));
    }

    @Test
    public void testCreate() throws Exception {
        CategoryDto category = new CategoryDto(1L, "Category 1", "Description 1");

        when(categoryService.create(any(CategoryDto.class))).thenReturn(category);

        mockMvc.perform(post("/api/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Category 1\", \"description\": \"Description 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Category 1"))
                .andExpect(jsonPath("$.description").value("Description 1"));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/api/categories/1"))
                .andExpect(status().isOk());
    }
}
