package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Product;
import com.targa.labs.myboutique.domain.Review;
import com.targa.labs.myboutique.domain.enumeration.ProductStatus;
import com.targa.labs.myboutique.repository.CategoryRepository;
import com.targa.labs.myboutique.repository.ProductRepository;
import com.targa.labs.myboutique.web.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Product product1 = new Product();
        product1.setId(1L);
        Product product2 = new Product();
        product2.setId(2L);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<ProductDto> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Product product = new Product();
        product.setId(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ProductDto result = productService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreate() {
        ProductDto productDto = new ProductDto();
        productDto.setName("Test Product");
        productDto.setDescription("Test Description");
        productDto.setPrice(100.0);
        productDto.setStatus("AVAILABLE");
        productDto.setSalesCounter(0);
        productDto.setCategoryId(1L);

        Product product = new Product();
        product.setId(1L);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(new Category()));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto result = productService.create(productDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testAddReview() {
        Product product = new Product();
        product.setId(1L);
        product.setReviews(Collections.emptySet());

        Review review = new Review();
        review.setId(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.saveAndFlush(any(Product.class))).thenReturn(product);

        ProductDto result = productService.addReview(1L, review);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(1, product.getReviews().size());
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).saveAndFlush(any(Product.class));
    }

    @Test
    public void testDelete() {
        doNothing().when(productRepository).deleteById(1L);

        productService.delete(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
