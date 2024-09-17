package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductDtoTest {

    @Test
    public void testAllArgsConstructor() {
        Set<ReviewDto> reviews = new HashSet<>();
        reviews.add(new ReviewDto(1L, "Great product", "I really liked this product", 5L));

        ProductDto productDto = new ProductDto(1L, "Product Name", "Product Description", new BigDecimal("19.99"), "AVAILABLE", 10, reviews, 2L);

        assertEquals(1L, productDto.getId());
        assertEquals("Product Name", productDto.getName());
        assertEquals("Product Description", productDto.getDescription());
        assertEquals(new BigDecimal("19.99"), productDto.getPrice());
        assertEquals("AVAILABLE", productDto.getStatus());
        assertEquals(10, productDto.getSalesCounter());
        assertEquals(reviews, productDto.getReviews());
        assertEquals(2L, productDto.getCategoryId());
    }

    @Test
    public void testNoArgsConstructor() {
        ProductDto productDto = new ProductDto();

        assertNotNull(productDto);
    }

    @Test
    public void testSettersAndGetters() {
        Set<ReviewDto> reviews = new HashSet<>();
        reviews.add(new ReviewDto(1L, "Great product", "I really liked this product", 5L));

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("Product Name");
        productDto.setDescription("Product Description");
        productDto.setPrice(new BigDecimal("19.99"));
        productDto.setStatus("AVAILABLE");
        productDto.setSalesCounter(10);
        productDto.setReviews(reviews);
        productDto.setCategoryId(2L);

        assertEquals(1L, productDto.getId());
        assertEquals("Product Name", productDto.getName());
        assertEquals("Product Description", productDto.getDescription());
        assertEquals(new BigDecimal("19.99"), productDto.getPrice());
        assertEquals("AVAILABLE", productDto.getStatus());
        assertEquals(10, productDto.getSalesCounter());
        assertEquals(reviews, productDto.getReviews());
        assertEquals(2L, productDto.getCategoryId());
    }
}
