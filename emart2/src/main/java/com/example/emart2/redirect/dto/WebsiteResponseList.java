package com.example.emart2.redirect.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WebsiteResponseList {
  private List<WebsiteResponse> websiteList;

  public WebsiteResponseList(){
    websiteList = new ArrayList<>();
  }
  public WebsiteResponseList(List<WebsiteResponse> websiteList){
    this.websiteList = websiteList;
  }

  public void addWebsite(WebsiteResponse dto){
    this.websiteList.add(dto);
  }
}
