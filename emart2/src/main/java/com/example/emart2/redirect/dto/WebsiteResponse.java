package com.example.emart2.redirect.dto;

import com.example.emart2.type.StageType;
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
  private boolean isDev;

  public WebsiteResponse() {
  }

  @Builder
  public WebsiteResponse(Long id, String name, String description, String url, StageType stage, boolean isDev) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.url = url;
    this.stage = stage;
    this.isDev = isDev;
  }

}
