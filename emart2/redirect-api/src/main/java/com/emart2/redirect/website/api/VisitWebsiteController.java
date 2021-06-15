package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/websites/{id}/visit")
public class VisitWebsiteController {
  private final WebsiteManager websiteManager;

  public VisitWebsiteController(WebsiteManager websiteManager) {
    this.websiteManager = websiteManager;
  }

  @PutMapping
  public CommonResponse<Void> visitWebsite(@PathVariable("id") Long id) {
    websiteManager.visitWebsite(id);
    return CommonResponse.ok();
  }

}
