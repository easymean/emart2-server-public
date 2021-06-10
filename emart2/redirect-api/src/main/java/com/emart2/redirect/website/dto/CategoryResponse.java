package com.emart2.redirect.website.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
  private Long id;
  private String name;
  private String description;
  private int order;

  public CategoryResponse() {
  }

  @Builder
  public CategoryResponse(Long id, String name, String description, int order) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.order = order;
  }

}
