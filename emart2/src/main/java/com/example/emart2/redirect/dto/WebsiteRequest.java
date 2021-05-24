package com.example.emart2.redirect.dto;


import com.example.emart2.type.StageType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WebsiteRequest {

  private final String name;
  private final String description;
  private final String url;
  private final StageType stage;
  private final Long categoryId;
  private final boolean isDev;


  @Builder
  public WebsiteRequest(String name, String description, String url, StageType stage, Long categoryId, boolean isDev) {
    this.name = name;
    this.description = description;
    this.url = url;
    this.stage = stage;
    this.categoryId = categoryId;
    this.isDev = isDev;
  }


}
