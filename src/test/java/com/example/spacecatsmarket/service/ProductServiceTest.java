package com.example.spacecatsmarket.service;

import com.example.spacecatsmarket.domain.Product;
import com.example.spacecatsmarket.dto.ProductDTO;
import com.example.spacecatsmarket.web.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        Product product = new Product(1L, "Galaxy Food", 19.99, "For cosmic cats", null);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Galaxy Food");

        when(productMapper.toDTO(product)).thenReturn(productDTO);
        productService.createProduct(productDTO);

        List<ProductDTO> products = productService.getAllProducts();
        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("Galaxy Food", products.get(0).getName());
    }

    @Test
    void testGetProductById_Found() {

        Product product = new Product(1L, "Galaxy Food", 19.99, "For cosmic cats", null);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Galaxy Food");

        productService.createProduct(productDTO);

        Optional<ProductDTO> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals("Galaxy Food", result.get().getName());
    }

    @Test
    void testGetProductById_NotFound() {
        Optional<ProductDTO> result = productService.getProductById(999L);

        assertFalse(result.isPresent());
    }

    @Test
    void testDeleteProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Galaxy Food");
        productService.createProduct(productDTO);

        boolean isDeleted = productService.deleteProduct(1L);

        assertTrue(isDeleted);
    }
}
