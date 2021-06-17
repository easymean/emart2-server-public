package com.emart2.redirect.website.dto;

import com.emart2.redirect.type.StageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WebsiteListDto {
  private List<Response> websiteList;

  public WebsiteListDto() {
    websiteList = new ArrayList<>();
  }

  public WebsiteListDto(List<Response> websiteList) {
    this.websiteList = websiteList;
  }

  @Getter
  @Setter
  public static class Response {
    private Long id;
    private String name;
    private String description;
    private String url;
    private StageType stage;
    private boolean dev;

    public Response() {
    }

    @Builder
    public Response(Long id, String name, String description, String url, StageType stage, boolean dev) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.url = url;
      this.stage = stage;
      this.dev = dev;
    }

  }

}
