package com.example.spacecatsmarket.dto;

import com.example.spacecatsmarket.dto.validation.CosmicWordCheck;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Field 'name' must not be blank.")
    @Size(min = 3, max = 50, message = "Field 'name' must be between 3 and 50 characters.")
    @CosmicWordCheck
    private String name;

    @NotNull(message = "Field 'price' is required.")
    @Min(value = 1, message = "Field 'price' must be greater than 0.")
    private Double price;

    @Size(max = 200, message = "Field 'description' must not exceed 200 characters.")
    private String description;

    @NotNull(message = "Field 'categoryId' is required.")
    private Long categoryId;
}
