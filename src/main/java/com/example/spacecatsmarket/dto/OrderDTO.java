package com.example.spacecatsmarket.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private List<Long> productIds; // Список ID продуктів
    private Double totalPrice;
    private LocalDateTime orderDate;
}
