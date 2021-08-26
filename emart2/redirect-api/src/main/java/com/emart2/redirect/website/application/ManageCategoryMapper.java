package com.emart2.redirect.website.application;

import com.emart2.redirect.common.CommonMapper;
import com.emart2.redirect.website.dto.ManageCategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapping;

public interface ManageCategoryMapper extends CommonMapper {

  WebsiteCategoryEntity toEntity(ManageCategoryDto.Create dto);

  WebsiteCategoryEntity toEntity(ManageCategoryDto.Update dto);

  @Mapping(source = "colOrder", target = "order")
  ManageCategoryDto.Response toDto(WebsiteCategoryEntity websiteCategoryEntity);

}
