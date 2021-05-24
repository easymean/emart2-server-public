package com.example.emart2.redirect.service;

import com.example.emart2.redirect.dto.CategoryRequest;
import com.example.emart2.redirect.dto.CategoryResponse;
import com.example.emart2.redirect.dto.CategoryResponseList;
import com.example.emart2.redirect.entity.Category;
import com.example.emart2.redirect.repository.CategoryRepository;
import com.example.emart2.exception.NotFoundException;
import com.example.emart2.type.ErrorCode;
import com.example.emart2.type.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
  CategoryRepository categoryRepository;
  CategoryMapper categoryMapper;

  public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
    this.categoryRepository = categoryRepository;
    this.categoryMapper = categoryMapper;
  }

  public CategoryResponse findById(Long id) {
    return categoryRepository.findById(id)
        .map(categoryMapper::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public CategoryResponseList getList() {
    List<Category> categories = categoryRepository.findAll();

    List<CategoryResponse> responses = categoryMapper.toDto(categories);
    CategoryResponseList categoryResponseList = new CategoryResponseList();
    categoryResponseList.setCategoryList(responses);
    return categoryResponseList;
  }

  public CategoryResponse createCategory(CategoryRequest req) {
    Category category = categoryMapper.toEntity(req);
    Category newCategory = categoryRepository.save(category);

    return categoryMapper.toDto(newCategory);
  }

  public CategoryResponse updateCategory(Long id, CategoryRequest req) {
    Optional<Category> optional = categoryRepository.findById(id);
    return optional
        .map(category -> {
          category.setName(req.getName());
          category.setDescription(req.getDescription());
          return category;
        })
        .map(categoryRepository::save)
        .map(categoryMapper::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public void deleteCategory(Long id) {
    Optional<Category> optional = categoryRepository.findById(id);
    optional
        .map(category -> {
          category.setActive(false);
          return category;
        })
        .map(categoryRepository::save)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }


}
