package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryDtoTest {

    @Test
    public void testAllArgsConstructor() {
        CategoryDto categoryDto = new CategoryDto(1L, "Electronics", "Category for electronic items", 100);
        assertEquals(1L, categoryDto.getId());
        assertEquals("Electronics", categoryDto.getName());
        assertEquals("Category for electronic items", categoryDto.getDescription());
        assertEquals(100, categoryDto.getProducts());
    }

    @Test
    public void testNoArgsConstructor() {
        CategoryDto categoryDto = new CategoryDto();
        assertNull(categoryDto.getId());
        assertNull(categoryDto.getName());
        assertNull(categoryDto.getDescription());
        assertNull(categoryDto.getProducts());
    }

    @Test
    public void testSettersAndGetters() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(2L);
        categoryDto.setName("Books");
        categoryDto.setDescription("Category for books");
        categoryDto.setProducts(50);

        assertEquals(2L, categoryDto.getId());
        assertEquals("Books", categoryDto.getName());
        assertEquals("Category for books", categoryDto.getDescription());
        assertEquals(50, categoryDto.getProducts());
    }

    @Test
    public void testEqualsAndHashCode() {
        CategoryDto categoryDto1 = new CategoryDto(1L, "Electronics", "Category for electronic items", 100);
        CategoryDto categoryDto2 = new CategoryDto(1L, "Electronics", "Category for electronic items", 100);
        CategoryDto categoryDto3 = new CategoryDto(2L, "Books", "Category for books", 50);

        assertEquals(categoryDto1, categoryDto2);
        assertNotEquals(categoryDto1, categoryDto3);
        assertEquals(categoryDto1.hashCode(), categoryDto2.hashCode());
        assertNotEquals(categoryDto1.hashCode(), categoryDto3.hashCode());
    }

    @Test
    public void testToString() {
        CategoryDto categoryDto = new CategoryDto(1L, "Electronics", "Category for electronic items", 100);
        String expectedString = "CategoryDto(id=1, name=Electronics, description=Category for electronic items, products=100)";
        assertEquals(expectedString, categoryDto.toString());
    }
}
