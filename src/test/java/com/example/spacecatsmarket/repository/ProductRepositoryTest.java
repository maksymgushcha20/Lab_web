package com.example.spacecatsmarket.repository;

import com.example.spacecatsmarket.domain.Category;
import com.example.spacecatsmarket.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Category testCategory;

    @BeforeEach
    public void setUp() {
        testCategory = new Category("Test Category", "Description");
        categoryRepository.save(testCategory);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product("Test Product", "Description", BigDecimal.valueOf(100.0), testCategory);
        Product savedProduct = productRepository.save(product);

        assertNotNull(savedProduct.getId());
        assertEquals("Test Product", savedProduct.getName());
    }

    @Test
    public void testFindAllProducts() {
        Product product1 = new Product("Product 1", "Description", BigDecimal.valueOf(50.0), testCategory);
        Product product2 = new Product("Product 2", "Description", BigDecimal.valueOf(75.0), testCategory);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product("Test Product", "Description", BigDecimal.valueOf(100.0), testCategory);
        Product savedProduct = productRepository.save(product);

        productRepository.delete(savedProduct);

        assertFalse(productRepository.findById(savedProduct.getId()).isPresent());
    }
}
