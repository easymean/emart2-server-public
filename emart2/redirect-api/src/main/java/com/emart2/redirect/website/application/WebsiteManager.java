package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.service.ManageWebsiteService;
import com.emart2.redirect.website.service.VisitWebsiteService;
import org.springframework.stereotype.Component;

@Component
public class WebsiteManager {

  private final ManageWebsiteService manageWebsiteService;
  private final VisitWebsiteService visitWebsiteService;

  public WebsiteManager(ManageWebsiteService manageWebsiteService, VisitWebsiteService visitWebsiteService) {
    this.manageWebsiteService = manageWebsiteService;
    this.visitWebsiteService = visitWebsiteService;
  }

  public ManageWebsiteDto.Response findWebsite(Long id) {
    return ManageWebsiteMapper.INSTANCE.toDto(manageWebsiteService.findById(id));
  }

  public ManageWebsiteDto.Response createWebsite(ManageWebsiteDto.Create req) {
    Long categoryId = req.getCategoryId();
    WebsiteEntity websiteEntity = manageWebsiteService.createWebsite(categoryId, ManageWebsiteMapper.INSTANCE.toEntity(req));
    return ManageWebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public ManageWebsiteDto.Response updateWebsite(Long id, ManageWebsiteDto.Update req) {
    WebsiteEntity websiteEntity = manageWebsiteService.updateWebsite(id, ManageWebsiteMapper.INSTANCE.toEntity(req));
    return ManageWebsiteMapper.INSTANCE.toDto(websiteEntity);
  }

  public void deleteWebsite(Long id) {
    manageWebsiteService.deleteWebsite(id);
  }

  public void visitWebsite(Long id) {
    visitWebsiteService.increaseFrequencyById(id);
  }
}
