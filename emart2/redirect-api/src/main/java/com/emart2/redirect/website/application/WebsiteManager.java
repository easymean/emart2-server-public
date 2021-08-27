package com.emart2.redirect.website.application;

import com.emart2.redirect.website.application.mapper.ManageWebsiteMapper;
import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.service.ManageWebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteManager {

  private final ManageWebsiteService manageWebsiteService;
  private final ManageWebsiteMapper manageWebsiteMapper;

  public WebsiteManager(ManageWebsiteService manageWebsiteService, ManageWebsiteMapper manageWebsiteMapper) {
    this.manageWebsiteService = manageWebsiteService;
    this.manageWebsiteMapper = manageWebsiteMapper;
  }

  public ManageWebsiteDto.Response findWebsite(Long id) {
    return manageWebsiteMapper.toDto(manageWebsiteService.findById(id));
  }

  public ManageWebsiteDto.Response createWebsite(ManageWebsiteDto.Create req) {
    Long categoryId = req.getCategoryId();
    WebsiteEntity websiteEntity = manageWebsiteService.createWebsite(categoryId, manageWebsiteMapper.toEntity(req));
    return manageWebsiteMapper.toDto(websiteEntity);
  }

  public ManageWebsiteDto.Response updateWebsite(Long id, ManageWebsiteDto.Update req) {
    WebsiteEntity websiteEntity = manageWebsiteService.updateWebsite(id, manageWebsiteMapper.toEntity(req));
    return manageWebsiteMapper.toDto(websiteEntity);
  }

  public void deleteWebsite(Long id) {
    manageWebsiteService.deleteWebsite(id);
  }
}
