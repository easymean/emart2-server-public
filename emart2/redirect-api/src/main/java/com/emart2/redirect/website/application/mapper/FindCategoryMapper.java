package com.emart2.redirect.website.application.mapper;

import com.emart2.redirect.website.dto.CategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FindCategoryMapper {

  List<CategoryDto.Response> toDto(List<WebsiteCategoryEntity> list);

  CategoryDto.Response toDto(WebsiteCategoryEntity category);
}
