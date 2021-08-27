package com.emart2.redirect.website.application;

import com.emart2.redirect.website.application.mapper.FindCategoryListMapper;
import com.emart2.redirect.website.dto.CategoryListDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.ManageWebsiteCategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryListFinder {
  private final ManageWebsiteCategoryService manageWebsiteCategoryService;
  private final FindCategoryListMapper mapper;

  public CategoryListFinder(ManageWebsiteCategoryService manageWebsiteCategoryService, FindCategoryListMapper mapper) {
    this.manageWebsiteCategoryService = manageWebsiteCategoryService;
    this.mapper = mapper;
  }

  public CategoryListDto findCategoryList() {
    List<WebsiteCategoryEntity> categories = manageWebsiteCategoryService.getList();
    return new CategoryListDto(mapper.toDto(categories));
  }


}
