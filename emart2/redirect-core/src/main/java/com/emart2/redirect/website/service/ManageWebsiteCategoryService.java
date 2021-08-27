package com.emart2.redirect.website.service;

import com.emart2.redirect.exception.NotFoundException;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
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
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
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
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
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
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorType.NOT_FOUND);
        });
  }

}
