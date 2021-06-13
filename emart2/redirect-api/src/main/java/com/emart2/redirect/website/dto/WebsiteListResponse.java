package com.emart2.redirect.website.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WebsiteListResponse {
  private List<WebsiteResponse> websiteList;

  public WebsiteListResponse() {
    websiteList = new ArrayList<>();
  }

  public WebsiteListResponse(List<WebsiteResponse> websiteList) {
    this.websiteList = websiteList;
  }

  public void addWebsite(WebsiteResponse dto) {
    this.websiteList.add(dto);
  }
}
