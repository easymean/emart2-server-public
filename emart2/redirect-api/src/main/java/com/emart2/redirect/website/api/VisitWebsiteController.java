package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteFinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisitWebsiteController {
  private final WebsiteFinder websiteFinder;

  public VisitWebsiteController(WebsiteFinder websiteFinder) {
    this.websiteFinder = websiteFinder;
  }

  @PutMapping("/v1/websites/visit/{id}")
  public CommonResponse<Void> visitWebsite(@PathVariable("id") Long id) {
    websiteFinder.visitWebsite(id);
    return CommonResponse.ok();
  }

}
