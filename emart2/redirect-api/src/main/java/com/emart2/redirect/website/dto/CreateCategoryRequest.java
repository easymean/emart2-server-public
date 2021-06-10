package com.emart2.redirect.website.dto;


import lombok.Getter;

@Getter
public class CreateCategoryRequest {
  private final String name;
  private final String description;

  public CreateCategoryRequest(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
