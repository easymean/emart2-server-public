package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CreateCategoryRequest;
import com.emart2.redirect.website.dto.UpdateCategoryRequest;
import com.emart2.redirect.website.dto.CategoryResponse;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  WebsiteCategoryEntity toEntity(CreateCategoryRequest dto);

  WebsiteCategoryEntity toEntity(UpdateCategoryRequest dto);

  @Mapping(source = "colOrder", target = "order")
  CategoryResponse toDto(WebsiteCategoryEntity websiteCategoryEntity);

  List<CategoryResponse> toDto(List<WebsiteCategoryEntity> list);
}
