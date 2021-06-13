package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CreateWebsiteRequest;
import com.emart2.redirect.website.dto.UpdateWebsiteRequest;
import com.emart2.redirect.website.dto.WebsiteResponse;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.service.WebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteManager {

  private final WebsiteService websiteService;

  public WebsiteManager(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }

  public WebsiteResponse createWebsite(CreateWebsiteRequest req) {
    Long categoryId = req.getCategoryId();
    WebsiteEntity websiteEntity = websiteService.createWebsite(categoryId, WebsiteMapper.INSTANCE.toEntity(req));
    return WebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public WebsiteResponse updateWebsite(Long id, UpdateWebsiteRequest req) {
    WebsiteEntity websiteEntity = websiteService.updateWebsite(id, WebsiteMapper.INSTANCE.toEntity(req));
    return WebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public void deleteWebsite(Long id) {
    websiteService.deleteWebsite(id);
  }
}
