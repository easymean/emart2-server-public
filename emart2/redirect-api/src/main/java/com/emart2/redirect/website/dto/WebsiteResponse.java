package com.emart2.redirect.website.dto;

import com.emart2.redirect.type.StageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteResponse {
  private Long id;
  private String name;
  private String description;
  private String url;
  private StageType stage;
  private boolean dev;

  public WebsiteResponse() {
  }

  @Builder
  public WebsiteResponse(Long id, String name, String description, String url, StageType stage, boolean dev) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.url = url;
    this.stage = stage;
    this.dev = dev;
  }

}