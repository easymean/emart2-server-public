package com.example.emart2.dto;

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

  public void addCategory(CategoryResponse dto){
    this.categoryList.add(dto);
  }
}
