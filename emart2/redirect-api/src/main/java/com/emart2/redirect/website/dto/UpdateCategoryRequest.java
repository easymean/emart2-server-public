package com.emart2.redirect.website.dto;


import lombok.Getter;

@Getter
public class UpdateCategoryRequest {
  private final String name;
  private final String description;

  public UpdateCategoryRequest(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
