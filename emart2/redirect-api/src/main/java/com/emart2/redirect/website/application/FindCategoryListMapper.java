package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CategoryListDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FindCategoryListMapper {
  FindCategoryListMapper INSTANCE = Mappers.getMapper(FindCategoryListMapper.class);

  @Mapping(source = "colOrder", target = "order")
  List<CategoryListDto.Response> toDto(List<WebsiteCategoryEntity> list);
}
