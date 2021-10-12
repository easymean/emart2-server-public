package com.emart2.redirect.website.application;

import com.emart2.redirect.website.application.mapper.FindCategoryMapper;
import com.emart2.redirect.website.dto.CategoryDto;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.service.ManageWebsiteCategoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFinder {
  private final ManageWebsiteCategoryService manageWebsiteCategoryService;
  private final FindCategoryMapper mapper;

  public CategoryFinder(ManageWebsiteCategoryService manageWebsiteCategoryService, FindCategoryMapper mapper) {
    this.manageWebsiteCategoryService = manageWebsiteCategoryService;
    this.mapper = mapper;
  }

  public List<CategoryDto.Response> findCategoryList() {
    List<WebsiteCategoryEntity> categories = manageWebsiteCategoryService.getList();
    return mapper.toDto(categories);
  }

  public CategoryDto.Response findCategory(Long id){
    return mapper.toDto(manageWebsiteCategoryService.findById(id));
  }


}
