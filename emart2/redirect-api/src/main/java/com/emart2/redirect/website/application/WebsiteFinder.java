package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.WebsiteListDto;
import com.emart2.redirect.website.service.WebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteFinder {

  private final WebsiteService websiteService;

  public WebsiteFinder(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }

  public WebsiteListDto searchWebsiteByKeyword(String keyword) {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(websiteService.findWebsiteByKeyword(keyword)));
  }

  public WebsiteListDto findWebsiteList(Long categoryId) {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(websiteService.findByCategoryId(categoryId)));
  }

  public WebsiteListDto findFrequentlyVisitedWebsites() {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(websiteService.findFrequentlyVisitedWebsites(5)));
  }

  public void visitWebsite(Long id) {
    websiteService.increaseFrequencyById(id);
  }


}
