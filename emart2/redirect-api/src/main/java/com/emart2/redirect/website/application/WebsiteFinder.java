package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.WebsiteListResponse;
import com.emart2.redirect.website.dto.WebsiteResponse;
import com.emart2.redirect.website.service.WebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteFinder {

  private final WebsiteService websiteService;

  public WebsiteFinder(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }

  public WebsiteResponse findWebsite(Long id) {
    return WebsiteMapper.INSTANCE.toDto(websiteService.findById(id));
  }

  public WebsiteListResponse searchWebsiteByKeyword(String keyword) {
    return new WebsiteListResponse(WebsiteMapper.INSTANCE.toDto(websiteService.findWebsiteByKeyword(keyword)));
  }

  public WebsiteListResponse findWebsiteList(Long categoryId) {
    return new WebsiteListResponse(WebsiteMapper.INSTANCE.toDto(websiteService.findByCategoryId(categoryId)));
  }

  public WebsiteListResponse findFrequentlyVisitedWebsites() {
    return new WebsiteListResponse(WebsiteMapper.INSTANCE.toDto(websiteService.findFrequentlyVisitedWebsites(5)));
  }

  public void visitWebsite(Long id) {
    websiteService.increaseFrequencyById(id);
  }


}
