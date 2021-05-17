package com.example.emart2.service;

import com.example.emart2.dto.CategoryDto;
import com.example.emart2.entity.Category;
import com.example.emart2.exception.NotFoundException;
import com.example.emart2.repository.CategoryRepository;
import com.example.emart2.type.ErrorCode;
import com.example.emart2.type.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
  CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }

  public CategoryDto.Response findById(Long id){
    return categoryRepository.findById(id)
        .map(CategoryMapper.INSTANCE::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public CategoryDto.Responses getList(){
    List<CategoryDto.Response> categoryList = new ArrayList<>();
    List<Category> categories = categoryRepository.findAll();

        categories = categoryRepository.findAll().stream().map(CategoryMapper.INSTANCE::toDto);

    return CategoryDto.Responses.builder()
        .categoryList(categories).build());
  }

  public CategoryDto.Response createCategory(CategoryDto.Request req){
    Category category = CategoryMapper.INSTANCE.toEntity(req);
    Category newCategory = categoryRepository.save(category);

    return CategoryMapper.INSTANCE.toDto(newCategory);
  }

  public CategoryDto.Response updateCategory(Long id, CategoryDto.Request req){
    Optional<Category> optional = categoryRepository.findById(id);
    return optional
        .map(category -> {
          category.setName(req.getName());
          category.setDescription(req.getDescription());
          return category;
        })
        .map(categoryRepository::save)
        .map(CategoryMapper.INSTANCE::toDto)
        .orElseGet(() -> {
          throw new NotFoundException("id에 해당하는 카테고리가 존재하지 않습니다.", ErrorCode.NOT_FOUND);
        });
  }

  public void deleteCategory(Long id){
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
