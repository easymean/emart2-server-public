package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CategoryListDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.WebsiteCategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFinder {
  private final WebsiteCategoryService websiteCategoryService;

  public CategoryFinder(WebsiteCategoryService websiteCategoryService) {
    this.websiteCategoryService = websiteCategoryService;
  }

  public CategoryListDto findCategoryList() {
    List<WebsiteCategoryEntity> categories = websiteCategoryService.getList();
    return new CategoryListDto(FindCategoryListMapper.INSTANCE.toDto(categories));
  }


}
