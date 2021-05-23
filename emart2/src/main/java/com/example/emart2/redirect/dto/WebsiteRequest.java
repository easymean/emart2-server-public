package com.example.emart2.redirect.dto;


import com.example.emart2.type.StageCode;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WebsiteRequest {

  private final String name;
  private final String description;
  private final String url;
  private final StageCode stage;
  private final Long categoryId;

  @Builder
  public WebsiteRequest(String name, String description, String url, StageCode stage, Long categoryId) {
    this.name = name;
    this.description = description;
    this.url = url;
    this.stage = stage;
    this.categoryId = categoryId;
  }

}
