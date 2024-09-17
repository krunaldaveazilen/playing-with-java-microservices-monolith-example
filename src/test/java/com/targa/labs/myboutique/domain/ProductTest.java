package com.targa.labs.myboutique.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductTest {

    @Test
    public void testProductConstructor() {
        String name = "Test Product";
        String description = "Test Description";
        BigDecimal price = new BigDecimal("19.99");
        Integer salesCounter = 10;
        Set<Review> reviews = new HashSet<>();
        Category category = new Category();
        ProductStatus status = ProductStatus.AVAILABLE;

        Product product = new Product(name, description, price, status, salesCounter, reviews, category);

        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
        assertEquals(status, product.getStatus());
        assertEquals(salesCounter, product.getSalesCounter());
        assertEquals(reviews, product.getReviews());
        assertEquals(category, product.getCategory());
    }

    @Test
    public void testEqualsAndHashCode() {
        String name = "Test Product";
        String description = "Test Description";
        BigDecimal price = new BigDecimal("19.99");
        Integer salesCounter = 10;
        Set<Review> reviews = new HashSet<>();
        Category category = new Category();
        ProductStatus status = ProductStatus.AVAILABLE;

        Product product1 = new Product(name, description, price, status, salesCounter, reviews, category);
        Product product2 = new Product(name, description, price, status, salesCounter, reviews, category);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void testToString() {
        String name = "Test Product";
        String description = "Test Description";
        BigDecimal price = new BigDecimal("19.99");
        Integer salesCounter = 10;
        Set<Review> reviews = new HashSet<>();
        Category category = new Category();
        ProductStatus status = ProductStatus.AVAILABLE;

        Product product = new Product(name, description, price, status, salesCounter, reviews, category);

        String expectedString = "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", salesCounter=" + salesCounter +
                ", reviews=" + reviews +
                ", category=" + category +
                '}';

        assertEquals(expectedString, product.toString());
    }
}
