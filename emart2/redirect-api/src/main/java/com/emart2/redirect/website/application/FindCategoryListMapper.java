package com.emart2.redirect.website.application;

import com.emart2.redirect.common.CommonMapper;
import com.emart2.redirect.website.dto.CategoryListDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import org.mapstruct.Mapping;

import java.util.List;

public interface FindCategoryListMapper extends CommonMapper {

  @Mapping(source = "colOrder", target = "order")
  List<CategoryListDto.Response> toDto(List<WebsiteCategoryEntity> list);
}
