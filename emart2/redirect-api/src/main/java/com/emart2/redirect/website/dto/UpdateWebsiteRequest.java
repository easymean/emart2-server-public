package com.emart2.redirect.website.dto;


import com.emart2.redirect.type.StageType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateWebsiteRequest {

  private final String name;
  private final String description;
  private final String url;
  private final StageType stage;
  private final Long categoryId;
  private final boolean dev;

  @Builder
  public UpdateWebsiteRequest(String name, String description, String url, StageType stage, Long categoryId, boolean dev) {
    this.name = name;
    this.description = description;
    this.url = url;
    this.stage = stage;
    this.categoryId = categoryId;
    this.dev = dev;
  }

}
