package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteManager;
import com.emart2.redirect.website.dto.CreateWebsiteRequest;
import com.emart2.redirect.website.dto.UpdateWebsiteRequest;
import com.emart2.redirect.website.dto.WebsiteResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/admin/website")
public class ManageWebsiteController {

  private final WebsiteManager websiteManager;

  public ManageWebsiteController(WebsiteManager websiteManager) {
    this.websiteManager = websiteManager;
  }

  @PostMapping
  public CommonResponse<WebsiteResponse> createWebsite(@RequestBody CreateWebsiteRequest request) {
    return CommonResponse.ok("success", websiteManager.createWebsite(request));
  }

  @PutMapping("{id}")
  public CommonResponse<WebsiteResponse> updateWebsite(@PathVariable("id") Long id, @RequestBody UpdateWebsiteRequest request) {
    return CommonResponse.ok("success", websiteManager.updateWebsite(id, request));
  }

  @DeleteMapping("{id}")
  public CommonResponse<Void> deleteWebsite(@PathVariable("id") Long id) {
    websiteManager.deleteWebsite(id);
    return CommonResponse.ok();
  }
}
