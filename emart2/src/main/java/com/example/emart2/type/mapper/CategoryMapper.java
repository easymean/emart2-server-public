package com.example.emart2.type.mapper;

import com.example.emart2.redirect.dto.CategoryRequest;
import com.example.emart2.redirect.dto.CategoryResponse;
import com.example.emart2.redirect.entity.Category;
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
