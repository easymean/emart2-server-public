package com.emart2.redirect.website.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryListResponse {
  private List<CategoryResponse> categoryList;

  public CategoryListResponse() {
    categoryList = new ArrayList<>();
  }

  public CategoryListResponse(List<CategoryResponse> categoryList) {
    this.categoryList = categoryList;
  }

  public void addCategory(CategoryResponse dto) {
    if (this.categoryList == null) {
      this.categoryList = new ArrayList<>();
    }
    this.categoryList.add(dto);
  }
}
