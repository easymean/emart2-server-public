package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CategoryListResponse;
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

  public CategoryListResponse findCategoryList() {
    List<WebsiteCategoryEntity> categories = websiteCategoryService.getList();
    return new CategoryListResponse(CategoryMapper.INSTANCE.toDto(categories));
  }


}
