package com.example.spacecatsmarket.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Category category;
}
