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

@Service
public class FindWebsiteListService {
  WebsiteRepository websiteRepository;
  WebsiteCategoryRepository websiteCategoryRepository;

  public FindWebsiteListService(WebsiteRepository websiteRepository, WebsiteCategoryRepository websiteCategoryRepository) {
    this.websiteRepository = websiteRepository;
    this.websiteCategoryRepository = websiteCategoryRepository;
  }

  public List<WebsiteEntity> findByCategoryId(Long categoryId) {
    WebsiteCategoryEntity websiteCategoryEntity = websiteCategoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });
    return new ArrayList<>(websiteCategoryEntity.getWebsiteEntities());
  }

  public List<WebsiteEntity> findFrequentlyVisitedWebsites(int count) {
    return websiteRepository.findFrequentlyUsedWebsiteList(count);
  }

  public List<WebsiteEntity> findWebsiteByKeyword(String keyword) {
    return websiteRepository.findAllByNameContainsAndIsActiveTrue(keyword);
  }

  public void increaseFrequencyById(Long id) {
    websiteRepository.increaseFrequency(id);
  }


}
