package com.example.spacecatsmarket.web;

import com.example.spacecatsmarket.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<ProductDTO> products = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId((long) (products.size() + 1));
        products.add(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
}
