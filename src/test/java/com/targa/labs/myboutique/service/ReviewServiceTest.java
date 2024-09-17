package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Review;
import com.targa.labs.myboutique.repository.ReviewRepository;
import com.targa.labs.myboutique.web.dto.ReviewDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    private Review review;
    private ReviewDto reviewDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        review = new Review("Title", "Description", 5L);
        review.setId(1L);
        reviewDto = new ReviewDto(1L, "Title", "Description", 5L);
    }

    @Test
    void testMapToDto() {
        ReviewDto dto = ReviewService.mapToDto(review);
        assertNotNull(dto);
        assertEquals(review.getId(), dto.getId());
        assertEquals(review.getTitle(), dto.getTitle());
        assertEquals(review.getDescription(), dto.getDescription());
        assertEquals(review.getRating(), dto.getRating());
    }

    @Test
    void testFindAll() {
        when(reviewRepository.findAll()).thenReturn(Arrays.asList(review));
        List<ReviewDto> dtos = reviewService.findAll();
        assertNotNull(dtos);
        assertEquals(1, dtos.size());
        assertEquals(review.getId(), dtos.get(0).getId());
    }

    @Test
    void testFindById() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));
        ReviewDto dto = reviewService.findById(1L);
        assertNotNull(dto);
        assertEquals(review.getId(), dto.getId());
    }

    @Test
    void testCreateDto() {
        when(reviewRepository.save(any(Review.class))).thenReturn(review);
        ReviewDto createdDto = reviewService.createDto(reviewDto);
        assertNotNull(createdDto);
        assertEquals(review.getId(), createdDto.getId());
    }

    @Test
    void testCreate() {
        when(reviewRepository.save(any(Review.class))).thenReturn(review);
        Review createdReview = reviewService.create(reviewDto);
        assertNotNull(createdReview);
        assertEquals(review.getId(), createdReview.getId());
    }

    @Test
    void testDelete() {
        doNothing().when(reviewRepository).deleteById(1L);
        reviewService.delete(1L);
        verify(reviewRepository, times(1)).deleteById(1L);
    }
}
