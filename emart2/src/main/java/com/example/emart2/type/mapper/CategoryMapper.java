package com.example.emart2.type.mapper;

import com.example.emart2.dto.CategoryRequest;
import com.example.emart2.dto.CategoryResponse;
import com.example.emart2.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  Category toEntity(CategoryRequest dto);

  CategoryResponse toDto(Category category);

  List<CategoryResponse> toDto(List<Category> list);
}
