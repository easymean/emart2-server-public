package com.example.emart2.redirect.controller;

import com.example.emart2.common.CommonResponse;
import com.example.emart2.redirect.dto.*;
import com.example.emart2.redirect.service.WebsiteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/website")
public class WebsiteController {

  WebsiteService websiteService;

  public WebsiteController(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }


  @PutMapping("freq/{id}")
  public CommonResponse<Void> IncreaseFreq(@PathVariable("id") Long id) {
    websiteService.increaseFreqById(id);
    return CommonResponse.ok("success", null);
  }

  @GetMapping("freq")
  public CommonResponse<WebsiteResponseList> getWebsiteByFreq() {
    return CommonResponse.ok("success", websiteService.getTopByFreq());
  }
  
  @GetMapping("{id}")
  public CommonResponse<WebsiteResponse> getWebsiteById(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", websiteService.findById(id));
  }

  @GetMapping
  public CommonResponse<WebsiteResponseList> getWebsiteByCategory(@RequestParam("category") Long categoryId) {
    return CommonResponse.ok("success", websiteService.findByCategory(categoryId));
  }

  @PostMapping
  public CommonResponse<WebsiteResponse> createWebsite(@RequestBody WebsiteRequest request) {
    return CommonResponse.ok("success", websiteService.createWebsite(request));
  }

  @PutMapping("{id}")
  public CommonResponse<WebsiteResponse> updateWebsite(@PathVariable("id") Long id, @RequestBody WebsiteRequest request) {
    return CommonResponse.ok("success", websiteService.updateWebsite(id, request));
  }

  @DeleteMapping("{id}")
  public CommonResponse<Void> deleteWebsite(@PathVariable("id") Long id) {
    websiteService.deleteWebsite(id);
    return CommonResponse.ok("정상적으로 삭제되었습니다.", null);
  }
}
