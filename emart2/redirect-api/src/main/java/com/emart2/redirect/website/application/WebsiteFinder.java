package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.WebsiteListDto;
import com.emart2.redirect.website.service.FindWebsiteListService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteFinder {

  private final FindWebsiteListService findWebsiteListService;

  public WebsiteFinder(FindWebsiteListService findWebsiteListService) {
    this.findWebsiteListService = findWebsiteListService;
  }

  public WebsiteListDto searchWebsiteByKeyword(String keyword) {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(findWebsiteListService.findWebsiteByKeyword(keyword)));
  }

  public WebsiteListDto findWebsiteList(Long categoryId) {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(findWebsiteListService.findByCategoryId(categoryId)));
  }

  public WebsiteListDto findFrequentlyVisitedWebsites() {
    return new WebsiteListDto(FindWebsiteListMapper.INSTANCE.toDto(findWebsiteListService.findFrequentlyVisitedWebsites(5)));
  }

}
