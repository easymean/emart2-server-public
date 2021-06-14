package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.service.WebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteManager {

  private final WebsiteService websiteService;

  public WebsiteManager(WebsiteService websiteService) {
    this.websiteService = websiteService;
  }


  public ManageWebsiteDto.Response findWebsite(Long id) {
    return ManageWebsiteMapper.INSTANCE.toDto(websiteService.findById(id));
  }


  public ManageWebsiteDto.Response createWebsite(ManageWebsiteDto.Create req) {
    Long categoryId = req.getCategoryId();
    WebsiteEntity websiteEntity = websiteService.createWebsite(categoryId, ManageWebsiteMapper.INSTANCE.toEntity(req));
    return ManageWebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public ManageWebsiteDto.Response updateWebsite(Long id, ManageWebsiteDto.Update req) {
    WebsiteEntity websiteEntity = websiteService.updateWebsite(id, ManageWebsiteMapper.INSTANCE.toEntity(req));
    return ManageWebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public void deleteWebsite(Long id) {
    websiteService.deleteWebsite(id);
  }
}
