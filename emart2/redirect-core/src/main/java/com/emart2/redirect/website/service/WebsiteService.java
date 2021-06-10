package com.emart2.redirect.website.service;

import com.emart2.redirect.exception.NotFoundException;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.entity.WebsiteEntity;
import com.emart2.redirect.website.repository.WebsiteCategoryRepository;
import com.emart2.redirect.website.repository.WebsiteRepository;
import com.emart2.redirect.type.ErrorType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {
  WebsiteRepository websiteRepository;
  WebsiteCategoryRepository websiteCategoryRepository;

  public WebsiteService(WebsiteRepository websiteRepository, WebsiteCategoryRepository websiteCategoryRepository) {
    this.websiteRepository = websiteRepository;
    this.websiteCategoryRepository = websiteCategoryRepository;
  }

  public WebsiteEntity findById(Long id) {
    return websiteRepository.findByIdAndIsActiveIsTrue(id)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });
  }

  public List<WebsiteEntity> findByCategoryId(Long categoryId) {
    WebsiteCategoryEntity websiteCategoryEntity = websiteCategoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });
    return new ArrayList<>(websiteCategoryEntity.getWebsiteEntities());
  }

  public WebsiteEntity createWebsite(Long categoryId, WebsiteEntity websiteEntity) {
    websiteCategoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .map(category -> {
          category.addWebsite(websiteEntity);
          return category;
        })
        .map(websiteCategoryRepository::save)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });

    return websiteRepository.save(websiteEntity);
  }

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
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorType.NOT_FOUND);
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
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });
  }

  public List<WebsiteEntity> findFrequentlyVisitedWebsites(int count) {
    return websiteRepository.findFrequentlyUsedWebsiteList(count);
  }

  public void increaseFrequencyById(Long id) {
    websiteRepository.increaseFrequency(id);
  }

  public List<WebsiteEntity> findWebsiteByKeyword(String keyword) {
    return websiteRepository.findAllByNameContainsAndIsActiveTrue(keyword);
  }


}
