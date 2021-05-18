package com.example.emart2.dto;


import lombok.Getter;

@Getter
public class CategoryRequest {

  private final String name;
  private final String description;

  public CategoryRequest(String name, String description) {
    this.name = name;
    this.description = description;
  }
}
