package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Category;
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
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveAndFindById() {
        Category category = new Category();
        category.setName("Electronics");
        category = categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findById(category.getId());
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Electronics");
    }

    @Test
    public void testDelete() {
        Category category = new Category();
        category.setName("Books");
        category = categoryRepository.save(category);

        categoryRepository.deleteById(category.getId());
        Optional<Category> foundCategory = categoryRepository.findById(category.getId());
        assertThat(foundCategory).isNotPresent();
    }
}
