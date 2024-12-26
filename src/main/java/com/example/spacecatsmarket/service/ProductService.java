package com.example.spacecatsmarket.service;

import com.example.spacecatsmarket.domain.Product;
import com.example.spacecatsmarket.dto.ProductDTO;
import com.example.spacecatsmarket.web.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    private final List<Product> products = new ArrayList<>();

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        return products.stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public void addProduct(ProductDTO productDTO) {
        products.add(productMapper.toEntity(productDTO));
    }
}
