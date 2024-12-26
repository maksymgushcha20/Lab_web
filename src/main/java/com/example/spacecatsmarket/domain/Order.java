package com.example.spacecatsmarket.domain;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private List<Product> products;
    private Double totalPrice;
    private LocalDateTime orderDate;
}
