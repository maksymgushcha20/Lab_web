package com.example.spacecatsmarket.service;

import com.example.spacecatsmarket.domain.Product;
import com.example.spacecatsmarket.dto.ProductDTO;
import com.example.spacecatsmarket.web.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> mockProducts = new ArrayList<>();
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;

        mockProducts.add(new Product(1L, "Space Cat Food", 19.99, "Best space food", null));
        mockProducts.add(new Product(2L, "Space Cat Toy", 9.99, "A toy for space adventures", null));
    }

    public List<ProductDTO> getAllProducts() {
        return mockProducts.stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return mockProducts.stream()
                .filter(product -> product.getId().equals(id))
                .map(productMapper::toDTO)
                .findFirst();
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setId((long) (mockProducts.size() + 1));
        mockProducts.add(product);
        return productMapper.toDTO(product);
    }

    public Optional<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        return mockProducts.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(existingProduct -> {
                    existingProduct.setName(productDTO.getName());
                    existingProduct.setPrice(productDTO.getPrice());
                    existingProduct.setDescription(productDTO.getDescription());
                    existingProduct.setCategory(productDTO.getCategoryId() != null
                            ? new Product()
                            : null);
                    return productMapper.toDTO(existingProduct);
                });
    }

    public boolean deleteProduct(Long id) {
        return mockProducts.removeIf(product -> product.getId().equals(id));
    }
}
