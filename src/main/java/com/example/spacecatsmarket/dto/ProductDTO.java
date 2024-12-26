package com.example.spacecatsmarket.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Field 'name' must not be blank.")
    private String name;

    @NotNull(message = "Field 'price' is required.")
    @Min(value = 1, message = "Field 'price' must be greater than 0.")
    private Double price;

    private String description;

    @NotNull(message = "Field 'categoryId' is required.")
    private Long categoryId;
}
