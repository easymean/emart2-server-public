package com.emart2.redirect.category.application.mapper;

import com.emart2.redirect.category.dto.ManageCategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManageCategoryMapper {

  WebsiteCategoryEntity toEntity(ManageCategoryDto.Create dto);

  WebsiteCategoryEntity toEntity(ManageCategoryDto.Update dto);

  @Mapping(source = "colOrder", target = "order")
  ManageCategoryDto.Response toDto(WebsiteCategoryEntity websiteCategoryEntity);

}
