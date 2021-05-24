package com.example.emart2.type.mapper;

import com.example.emart2.redirect.dto.CategoryRequest;
import com.example.emart2.redirect.dto.CategoryResponse;
import com.example.emart2.redirect.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  Category toEntity(CategoryRequest dto);

  @Mapping(source = "colOrder", target = "order")
  CategoryResponse toDto(Category category);

  List<CategoryResponse> toDto(List<Category> list);
}
