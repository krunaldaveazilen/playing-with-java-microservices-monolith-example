package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveAndFindById() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);
        product.setStatus("AVAILABLE");

        Product savedProduct = productRepository.save(product);
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Product");
    }

    @Test
    public void testDelete() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(100.0);
        product.setStatus("AVAILABLE");

        Product savedProduct = productRepository.save(product);
        productRepository.deleteById(savedProduct.getId());
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());

        assertThat(foundProduct).isNotPresent();
    }
}
