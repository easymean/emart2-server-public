package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.WebsiteManager;
import com.emart2.redirect.website.dto.ManageWebsiteDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/websites")
public class ManageWebsiteController {

  private final WebsiteManager websiteManager;

  public ManageWebsiteController(WebsiteManager websiteManager) {
    this.websiteManager = websiteManager;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CommonResponse<ManageWebsiteDto.Response> createWebsite(@RequestBody ManageWebsiteDto.Create request) {
    return CommonResponse.ok("success", websiteManager.createWebsite(request));
  }

  @GetMapping()
  public CommonResponse<List<ManageWebsiteDto.Response>> findWebsiteList() {
    return CommonResponse.ok("success", websiteManager.findWebsiteList());
  }


  @GetMapping("/{id}")
  public CommonResponse<ManageWebsiteDto.Response> findWebsite(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", websiteManager.findWebsite(id));
  }

  @PutMapping("/{id}")
  public CommonResponse<ManageWebsiteDto.Response> updateWebsite(@PathVariable("id") Long id,
                                                                 @RequestBody ManageWebsiteDto.Update request) {
    return CommonResponse.ok("success", websiteManager.updateWebsite(id, request));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<Void> deleteWebsite(@PathVariable("id") Long id) {
    websiteManager.deleteWebsite(id);
    return CommonResponse.ok();
  }
}
