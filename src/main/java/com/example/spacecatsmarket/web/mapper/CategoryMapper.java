package com.example.spacecatsmarket.web.mapper;

import com.example.spacecatsmarket.domain.Category;
import com.example.spacecatsmarket.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}