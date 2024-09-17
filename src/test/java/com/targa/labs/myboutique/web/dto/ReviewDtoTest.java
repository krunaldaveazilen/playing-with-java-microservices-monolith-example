package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewDtoTest {

    @Test
    public void testNoArgsConstructor() {
        ReviewDto reviewDto = new ReviewDto();
        assertNotNull(reviewDto);
    }

    @Test
    public void testAllArgsConstructor() {
        ReviewDto reviewDto = new ReviewDto(1L, "Great Product", "I really liked this product", 5L);
        assertEquals(1L, reviewDto.getId());
        assertEquals("Great Product", reviewDto.getTitle());
        assertEquals("I really liked this product", reviewDto.getDescription());
        assertEquals(5L, reviewDto.getRating());
    }

    @Test
    public void testSettersAndGetters() {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(1L);
        reviewDto.setTitle("Great Product");
        reviewDto.setDescription("I really liked this product");
        reviewDto.setRating(5L);

        assertEquals(1L, reviewDto.getId());
        assertEquals("Great Product", reviewDto.getTitle());
        assertEquals("I really liked this product", reviewDto.getDescription());
        assertEquals(5L, reviewDto.getRating());
    }
}
