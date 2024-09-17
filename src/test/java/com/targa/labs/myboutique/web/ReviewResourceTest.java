package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.ReviewService;
import com.targa.labs.myboutique.web.dto.ReviewDto;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReviewResourceTest {

    private MockMvc mockMvc;

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewResource reviewResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(reviewResource).build();
    }

    @Test
    public void testFindAll() throws Exception {
        ReviewDto review1 = new ReviewDto(1L, "Title1", "Description1", 5);
        ReviewDto review2 = new ReviewDto(2L, "Title2", "Description2", 4);
        List<ReviewDto> reviews = Arrays.asList(review1, review2);

        when(reviewService.findAll()).thenReturn(reviews);

        mockMvc.perform(get("/api/reviews"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[0].description").value("Description1"))
                .andExpect(jsonPath("$[0].rating").value(5))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].title").value("Title2"))
                .andExpect(jsonPath("$[1].description").value("Description2"))
                .andExpect(jsonPath("$[1].rating").value(4));

        verify(reviewService, times(1)).findAll();
        verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void testFindById() throws Exception {
        ReviewDto review = new ReviewDto(1L, "Title1", "Description1", 5);

        when(reviewService.findById(anyLong())).thenReturn(review);

        mockMvc.perform(get("/api/reviews/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Title1"))
                .andExpect(jsonPath("$.description").value("Description1"))
                .andExpect(jsonPath("$.rating").value(5));

        verify(reviewService, times(1)).findById(1L);
        verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void testCreate() throws Exception {
        ReviewDto review = new ReviewDto(1L, "Title1", "Description1", 5);

        when(reviewService.createDto(any(ReviewDto.class))).thenReturn(review);

        mockMvc.perform(post("/api/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Title1\",\"description\":\"Description1\",\"rating\":5}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Title1"))
                .andExpect(jsonPath("$.description").value("Description1"))
                .andExpect(jsonPath("$.rating").value(5));

        verify(reviewService, times(1)).createDto(any(ReviewDto.class));
        verifyNoMoreInteractions(reviewService);
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(reviewService).delete(anyLong());

        mockMvc.perform(delete("/api/reviews/{id}", 1L))
                .andExpect(status().isOk());

        verify(reviewService, times(1)).delete(1L);
        verifyNoMoreInteractions(reviewService);
    }
}
