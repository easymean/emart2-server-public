package com.emart2.redirect.website.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryListDto {
  private List<Response> categoryList;

  public CategoryListDto() {
    categoryList = new ArrayList<>();
  }

  public CategoryListDto(List<Response> categoryList) {
    this.categoryList = categoryList;
  }

  public void addCategory(Response dto) {
    if (this.categoryList == null) {
      this.categoryList = new ArrayList<>();
    }
    this.categoryList.add(dto);
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String name;
    private String description;


    @Builder
    public Response(Long id, String name, String description) {
      this.id = id;
      this.name = name;
      this.description = description;
    }
  }
}
