package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteFinder;
import com.emart2.redirect.website.dto.WebsiteListDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/websites")
public class FindWebsiteListController {

  private final WebsiteFinder websiteFinder;

  public FindWebsiteListController(WebsiteFinder websiteFinder) {
    this.websiteFinder = websiteFinder;
  }

  @GetMapping("/visit")
  public CommonResponse<WebsiteListDto> findFrequentlyVisitedWebsites() {
    return CommonResponse.ok("success", websiteFinder.findFrequentlyVisitedWebsites());
  }

  @GetMapping("/search")
  public CommonResponse<WebsiteListDto> searchWebsiteByKeyword(@RequestParam("keyword") String keyword) {
    return CommonResponse.ok("success", websiteFinder.searchWebsiteByKeyword(keyword));
  }

  @GetMapping
  public CommonResponse<WebsiteListDto> findWebsiteList(@RequestParam("category") Long categoryId) {
    return CommonResponse.ok("success", websiteFinder.findWebsiteList(categoryId));
  }


}
