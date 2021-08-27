package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.WebsiteListDto;
import com.emart2.redirect.website.service.FindWebsiteListService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteFinder {

  private final FindWebsiteListService findWebsiteListService;
  private final FindWebsiteListMapper mapper;

  public WebsiteFinder(FindWebsiteListService findWebsiteListService, FindWebsiteListMapper mapper) {
    this.findWebsiteListService = findWebsiteListService;
    this.mapper = mapper;
  }

  public WebsiteListDto searchWebsiteByKeyword(String keyword) {
    return new WebsiteListDto(mapper.toDto(findWebsiteListService.findWebsiteByKeyword(keyword)));
  }

  public WebsiteListDto findWebsiteList(Long categoryId) {
    return new WebsiteListDto(mapper.toDto(findWebsiteListService.findByCategoryId(categoryId)));
  }

  public WebsiteListDto findFrequentlyVisitedWebsites() {
    return new WebsiteListDto(mapper.toDto(findWebsiteListService.findFrequentlyVisitedWebsites(5)));
  }

}
