package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CreateCategoryRequest;
import com.emart2.redirect.website.dto.UpdateCategoryRequest;
import com.emart2.redirect.website.dto.CategoryResponse;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.WebsiteCategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager {

  private final WebsiteCategoryService categoryService;

  public CategoryManager(WebsiteCategoryService categoryService) {
    this.categoryService = categoryService;
  }

  public CategoryResponse findCategory(Long id) {
    return CategoryMapper.INSTANCE.toDto(categoryService.findById(id));
  }

  public CategoryResponse createCategory(CreateCategoryRequest req) {
    WebsiteCategoryEntity category = categoryService.createCategory(CategoryMapper.INSTANCE.toEntity(req));

    return CategoryMapper.INSTANCE.toDto(category);
  }

  public CategoryResponse updateCategory(Long id, UpdateCategoryRequest req) {
    WebsiteCategoryEntity category = categoryService.updateCategory(id, CategoryMapper.INSTANCE.toEntity(req));
    return CategoryMapper.INSTANCE.toDto(category);
  }

  public void deleteCategory(Long id) {
    categoryService.deleteCategory(id);
  }
}
