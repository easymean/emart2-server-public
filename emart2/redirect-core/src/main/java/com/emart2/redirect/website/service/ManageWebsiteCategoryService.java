package com.emart2.redirect.website.service;

import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import com.emart2.redirect.website.exception.CategoryNotFoundException;
import com.emart2.redirect.website.repository.WebsiteCategoryRepository;
import com.emart2.redirect.type.ErrorType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageWebsiteCategoryService {
  WebsiteCategoryRepository websiteCategoryRepository;

  public ManageWebsiteCategoryService(WebsiteCategoryRepository websiteCategoryRepository) {
    this.websiteCategoryRepository = websiteCategoryRepository;
  }

  public WebsiteCategoryEntity findById(Long id) {
    return websiteCategoryRepository.findByIdAndIsActiveIsTrue(id)
        .orElseGet(() -> {
          throw new CategoryNotFoundException();
        });
  }

  public List<WebsiteCategoryEntity> getList() {
    return websiteCategoryRepository.findAllByIsActiveIsTrue();
  }

  public WebsiteCategoryEntity createCategory(WebsiteCategoryEntity websiteCategoryEntity) {
    return websiteCategoryRepository.save(websiteCategoryEntity);
  }

  public WebsiteCategoryEntity updateCategory(Long id, WebsiteCategoryEntity req) {
    Optional<WebsiteCategoryEntity> optional = websiteCategoryRepository.findByIdAndIsActiveIsTrue(id);
    return optional
        .map(category -> {
          category.setName(req.getName());
          category.setDescription(req.getDescription());
          return category;
        })
            .map(websiteCategoryRepository::save)
        .orElseGet(() -> {
          throw new CategoryNotFoundException();
        });
  }

  public void deleteCategory(Long id) {
    Optional<WebsiteCategoryEntity> optional = websiteCategoryRepository.findByIdAndIsActiveIsTrue(id);
    optional
        .map(category -> {
          category.setActive(false);
          return category;
        })
        .map(websiteCategoryRepository::save)
        .orElseGet(() -> {
          throw new CategoryNotFoundException();
        });
  }

}
