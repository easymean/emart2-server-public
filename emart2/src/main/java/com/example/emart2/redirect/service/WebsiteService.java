package com.example.emart2.redirect.service;

import com.example.emart2.exception.NotFoundException;
import com.example.emart2.redirect.dto.*;
import com.example.emart2.redirect.entity.Category;
import com.example.emart2.redirect.entity.Website;
import com.example.emart2.redirect.repository.CategoryRepository;
import com.example.emart2.redirect.repository.WebsiteRepository;
import com.example.emart2.type.ErrorCode;
import com.example.emart2.type.mapper.WebsiteMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {
  WebsiteRepository websiteRepository;
  WebsiteMapper websiteMapper;
  CategoryRepository categoryRepository;

  public WebsiteService(WebsiteRepository websiteRepository, WebsiteMapper websiteMapper, CategoryRepository categoryRepository) {
    this.websiteRepository = websiteRepository;
    this.websiteMapper = websiteMapper;
    this.categoryRepository = categoryRepository;
  }

  // id가 null이면 illegalargumentexception
  public WebsiteResponse findById(Long id) {
    return websiteRepository.findByIdAndIsActiveIsTrue(id)
        .map(websiteMapper::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public WebsiteResponseList findByCategory(Long categoryId) {
    Category category = categoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
    List<Website> websites = new ArrayList<>(category.getWebsites());
    return new WebsiteResponseList(websiteMapper.toDto(websites));
  }

  public WebsiteResponseList getList() {
    List<Website> categories = websiteRepository.findAllByIsActiveIsTrue();

    List<WebsiteResponse> responses = websiteMapper.toDto(categories);
    WebsiteResponseList websiteResponseList = new WebsiteResponseList();
    websiteResponseList.setWebsiteList(responses);
    return websiteResponseList;
  }

  public WebsiteResponse createWebsite(WebsiteRequest req) {
    Website website = websiteMapper.toEntity(req);
    Long categoryId = req.getCategoryId();

    categoryRepository.findByIdAndIsActiveIsTrue(categoryId)
        .map(category -> {
          category.addWebsite(website);
          return category;
        })
        .map(categoryRepository::save)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });

    Website newCategory = websiteRepository.save(website);

    return websiteMapper.toDto(newCategory);
  }

  public WebsiteResponse updateWebsite(Long id, WebsiteRequest req) {
    Optional<Website> optional = websiteRepository.findByIdAndIsActiveIsTrue(id);
    return optional
        .map(website -> {
          website.setName(req.getName());
          website.setDescription(req.getDescription());
          return website;
        })
        .map(websiteRepository::save)
        .map(websiteMapper::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public void deleteWebsite(Long id) {
    Optional<Website> optional = websiteRepository.findByIdAndIsActiveIsTrue(id);
    optional
        .map(category -> {
          category.setActive(false);
          return category;
        })
        .map(websiteRepository::save)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 웹페이지가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public WebsiteResponseList getTopByFreq() {
    return new WebsiteResponseList(websiteMapper.toDto(websiteRepository.findTop3ByFreq()));
  }

  public void increaseFreqById(Long id) {
    websiteRepository.increaseFreq(id);
  }


}
