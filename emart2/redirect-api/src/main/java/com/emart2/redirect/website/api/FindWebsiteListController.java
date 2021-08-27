package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteListFinder;
import com.emart2.redirect.website.dto.WebsiteListDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/websites")
public class FindWebsiteListController {

  private final WebsiteListFinder websiteListFinder;

  public FindWebsiteListController(WebsiteListFinder websiteListFinder) {
    this.websiteListFinder = websiteListFinder;
  }

  @PutMapping("{id}/visit")
  public CommonResponse<Void> visitWebsite(@PathVariable("id") Long id) {
    websiteListFinder.visitWebsite(id);
    return CommonResponse.ok();
  }

  @GetMapping("/visit")
  public CommonResponse<WebsiteListDto> findFrequentlyVisitedWebsites() {
    return CommonResponse.ok("success", websiteListFinder.findFrequentlyVisitedWebsites());
  }

  @GetMapping("/search")
  public CommonResponse<WebsiteListDto> searchWebsiteByKeyword(@RequestParam("keyword") String keyword) {
    return CommonResponse.ok("success", websiteListFinder.searchWebsiteByKeyword(keyword));
  }

  @GetMapping
  public CommonResponse<WebsiteListDto> findWebsiteList(@RequestParam("category") Long categoryId) {
    return CommonResponse.ok("success", websiteListFinder.findWebsiteList(categoryId));
  }


}
