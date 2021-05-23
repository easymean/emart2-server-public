package com.example.emart2.redirect.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WebsiteResponse {
  private Long id;
  private String name;
  private String description;
  private String url;

  public WebsiteResponse(){}

  @Builder
  public WebsiteResponse(Long id, String name, String description, String url){
    this.id = id;
    this.name = name;
    this.description = description;
    this.url = url;
  }

}
