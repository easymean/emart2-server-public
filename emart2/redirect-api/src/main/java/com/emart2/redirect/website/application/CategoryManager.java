package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.ManageCategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.WebsiteCategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager {

  private final WebsiteCategoryService categoryService;

  public CategoryManager(WebsiteCategoryService categoryService) {
    this.categoryService = categoryService;
  }

  public ManageCategoryDto.Response findCategory(Long id) {
    return ManageCategoryMapper.INSTANCE.toDto(categoryService.findById(id));
  }

  public ManageCategoryDto.Response createCategory(ManageCategoryDto.Create req) {
    WebsiteCategoryEntity category = categoryService.createCategory(ManageCategoryMapper.INSTANCE.toEntity(req));

    return ManageCategoryMapper.INSTANCE.toDto(category);
  }

  public ManageCategoryDto.Response updateCategory(Long id, ManageCategoryDto.Update req) {
    WebsiteCategoryEntity category = categoryService.updateCategory(id, ManageCategoryMapper.INSTANCE.toEntity(req));
    return ManageCategoryMapper.INSTANCE.toDto(category);
  }

  public void deleteCategory(Long id) {
    categoryService.deleteCategory(id);
  }
}
