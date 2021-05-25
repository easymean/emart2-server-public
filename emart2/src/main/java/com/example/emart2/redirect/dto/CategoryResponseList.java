package com.example.emart2.redirect.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryResponseList {
  private List<CategoryResponse> categoryList;

  public CategoryResponseList(){
    categoryList = new ArrayList<>();
  }
  public CategoryResponseList(List<CategoryResponse> categoryList){
    this.categoryList = categoryList;
  }

  public void addCategory(CategoryResponse dto){
    if(this.categoryList == null){
      this.categoryList = new ArrayList<>();
    }
    this.categoryList.add(dto);
  }
}
