package com.example.spacecatsmarket.web.mapper;

import com.example.spacecatsmarket.domain.Order;
import com.example.spacecatsmarket.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "products", target = "productIds")
    OrderDTO toDTO(Order order);

    @Mapping(source = "productIds", target = "products")
    Order toEntity(OrderDTO orderDTO);
}