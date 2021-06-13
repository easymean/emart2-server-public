package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteFinder;
import com.emart2.redirect.website.dto.WebsiteListResponse;
import com.emart2.redirect.website.dto.WebsiteResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/websites")
public class FindWebsiteController {

  private final WebsiteFinder websiteFinder;

  public FindWebsiteController(WebsiteFinder websiteFinder) {
    this.websiteFinder = websiteFinder;
  }

  @GetMapping("/visit")
  public CommonResponse<WebsiteListResponse> findFrequentlyVisitedWebsites() {
    return CommonResponse.ok("success", websiteFinder.findFrequentlyVisitedWebsites());
  }

  @GetMapping("/search")
  public CommonResponse<WebsiteListResponse> searchWebsiteByKeyword(@RequestParam("keyword") String keyword) {
    return CommonResponse.ok("success", websiteFinder.searchWebsiteByKeyword(keyword));
  }

  @GetMapping("/{id}")
  public CommonResponse<WebsiteResponse> findWebsite(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", websiteFinder.findWebsite(id));
  }

  @GetMapping
  public CommonResponse<WebsiteListResponse> findWebsiteList(@RequestParam("category") Long categoryId) {
    return CommonResponse.ok("success", websiteFinder.findWebsiteList(categoryId));
  }


}
