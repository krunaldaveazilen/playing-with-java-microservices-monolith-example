package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void testSaveReview() {
        Review review = new Review();
        review.setTitle("Great product");
        review.setContent("I really liked this product.");
        review.setRating(5);

        Review savedReview = reviewRepository.save(review);

        assertThat(savedReview).isNotNull();
        assertThat(savedReview.getId()).isNotNull();
        assertThat(savedReview.getTitle()).isEqualTo("Great product");
        assertThat(savedReview.getContent()).isEqualTo("I really liked this product.");
        assertThat(savedReview.getRating()).isEqualTo(5);
    }

    @Test
    public void testFindReviewById() {
        Review review = new Review();
        review.setTitle("Great product");
        review.setContent("I really liked this product.");
        review.setRating(5);

        Review savedReview = reviewRepository.save(review);

        Optional<Review> foundReview = reviewRepository.findById(savedReview.getId());

        assertThat(foundReview).isPresent();
        assertThat(foundReview.get().getId()).isEqualTo(savedReview.getId());
    }

    @Test
    public void testFindAllReviews() {
        Review review1 = new Review();
        review1.setTitle("Great product");
        review1.setContent("I really liked this product.");
        review1.setRating(5);

        Review review2 = new Review();
        review2.setTitle("Not bad");
        review2.setContent("The product is okay.");
        review2.setRating(3);

        reviewRepository.save(review1);
        reviewRepository.save(review2);

        List<Review> reviews = reviewRepository.findAll();

        assertThat(reviews).hasSize(2);
    }

    @Test
    public void testDeleteReview() {
        Review review = new Review();
        review.setTitle("Great product");
        review.setContent("I really liked this product.");
        review.setRating(5);

        Review savedReview = reviewRepository.save(review);

        reviewRepository.deleteById(savedReview.getId());

        Optional<Review> foundReview = reviewRepository.findById(savedReview.getId());

        assertThat(foundReview).isNotPresent();
    }
}
