package com.emart2.redirect.website.service;

import com.emart2.redirect.type.ErrorType;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.exception.CategoryNotFoundException;
import com.emart2.redirect.website.exception.SiteNotFoundException;
import com.emart2.redirect.website.repository.WebsiteCategoryRepository;
import com.emart2.redirect.website.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManageWebsiteService {
  WebsiteRepository websiteRepository;
  WebsiteCategoryRepository websiteCategoryRepository;

  public ManageWebsiteService(WebsiteRepository websiteRepository, WebsiteCategoryRepository websiteCategoryRepository) {
    this.websiteRepository = websiteRepository;
    this.websiteCategoryRepository = websiteCategoryRepository;
  }

  public List<WebsiteEntity> findWebsiteList(){
      return websiteRepository.findAllByIsActiveIsTrue();
  }

  public WebsiteEntity findById(Long id) {
    return websiteRepository.findByIdAndIsActiveIsTrue(id)
        .orElseGet(() -> {
          throw new SiteNotFoundException();
        });
  }

  @Transactional
  public WebsiteEntity createWebsite(Long categoryId, WebsiteEntity websiteEntity) {
    websiteCategoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .map(category -> {
          category.addWebsite(websiteEntity);
          return category;
        })
        .map(websiteCategoryRepository::save)
            .map(category -> {
                websiteEntity.setCategoryName(category.getName());
                return category;
            })
        .orElseGet(() -> {
          throw new CategoryNotFoundException();
        });

    return websiteRepository.save(websiteEntity);
  }

  @Transactional
  public WebsiteEntity updateWebsite(Long id, WebsiteEntity req) {
    Optional<WebsiteEntity> optional = websiteRepository.findByIdAndIsActiveIsTrue(id);
    return optional
        .map(website -> {
          website.setName(req.getName());
          website.setDescription(req.getDescription());
          website.setUrl(req.getUrl());
          website.setStage(req.getStage());
          website.setDev(req.isDev());
          return website;
        })
        .map(websiteRepository::save)
        .orElseGet(() -> {
          throw new SiteNotFoundException();
        });
  }

  public void deleteWebsite(Long id) {
    Optional<WebsiteEntity> optional = websiteRepository.findByIdAndIsActiveIsTrue(id);
    optional
        .map(category -> {
          category.setActive(false);
          return category;
        })
        .map(websiteRepository::save)
        .orElseGet(() -> {
          throw new SiteNotFoundException();
        });
  }

}
