package com.emart2.redirect.user.application;

import com.emart2.redirect.category.application.mapper.ManageCategoryMapper;
import com.emart2.redirect.category.dto.ManageCategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.ManageWebsiteCategoryService;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

  private final ManageWebsiteCategoryService categoryService;
  private final ManageCategoryMapper mapper;

  public UserManager(ManageWebsiteCategoryService categoryService, ManageCategoryMapper mapper) {
    this.categoryService = categoryService;
    this.mapper = mapper;
  }

  public ManageCategoryDto.Response findCategory(Long id) {
    return mapper.toDto(categoryService.findById(id));
  }

  public ManageCategoryDto.Response createCategory(ManageCategoryDto.Create req) {
    WebsiteCategoryEntity category = categoryService.createCategory(mapper.toEntity(req));

    return mapper.toDto(category);
  }

  public ManageCategoryDto.Response updateCategory(Long id, ManageCategoryDto.Update req) {
    WebsiteCategoryEntity category = categoryService.updateCategory(id, mapper.toEntity(req));
    return mapper.toDto(category);
  }

  public void deleteCategory(Long id) {
    categoryService.deleteCategory(id);
  }
}
