package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Category;
import com.targa.labs.myboutique.repository.CategoryRepository;
import com.targa.labs.myboutique.web.dto.CategoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMapToDto() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Test Category");
        category.setDescription("Test Description");
        category.setProducts(Collections.emptySet());

        CategoryDto categoryDto = CategoryService.mapToDto(category);

        assertNotNull(categoryDto);
        assertEquals(1L, categoryDto.getId());
        assertEquals("Test Category", categoryDto.getName());
        assertEquals("Test Description", categoryDto.getDescription());
        assertEquals(0, categoryDto.getProductCount());
    }

    @Test
    void testFindAll() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Test Category");
        category.setDescription("Test Description");
        category.setProducts(Collections.emptySet());

        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));

        List<CategoryDto> categoryDtos = categoryService.findAll();

        assertNotNull(categoryDtos);
        assertEquals(1, categoryDtos.size());
        assertEquals("Test Category", categoryDtos.get(0).getName());
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Test Category");
        category.setDescription("Test Description");
        category.setProducts(Collections.emptySet());

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        CategoryDto categoryDto = categoryService.findById(1L);

        assertNotNull(categoryDto);
        assertEquals(1L, categoryDto.getId());
        assertEquals("Test Category", categoryDto.getName());
    }

    @Test
    void testCreate() {
        CategoryDto categoryDto = new CategoryDto(null, "Test Category", "Test Description", 0);
        Category category = new Category("Test Category", "Test Description", Collections.emptySet());
        category.setId(1L);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDto createdCategoryDto = categoryService.create(categoryDto);

        assertNotNull(createdCategoryDto);
        assertEquals(1L, createdCategoryDto.getId());
        assertEquals("Test Category", createdCategoryDto.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(categoryRepository).deleteById(1L);

        categoryService.delete(1L);

        verify(categoryRepository, times(1)).deleteById(1L);
    }
}
