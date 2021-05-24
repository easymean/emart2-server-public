package com.example.emart2.redirect.controller;

import com.example.emart2.common.CommonResponse;
import com.example.emart2.redirect.dto.CategoryRequest;
import com.example.emart2.redirect.dto.CategoryResponse;
import com.example.emart2.redirect.dto.CategoryResponseList;
import com.example.emart2.redirect.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

  CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("{id}")
  public CommonResponse<CategoryResponse> getCategoryById(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", categoryService.findById(id));
  }

  @GetMapping
  public CommonResponse<CategoryResponseList> getCategoryList() {
    return CommonResponse.ok("success", categoryService.getList());
  }

  @PostMapping
  public CommonResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
    return CommonResponse.ok("success", categoryService.createCategory(request));
  }

  @PutMapping("{id}")
  public CommonResponse<CategoryResponse> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequest request) {
    return CommonResponse.ok("success", categoryService.updateCategory(id, request));
  }

  @DeleteMapping("{id}")
  public CommonResponse<Void> deleteCategory(@PathVariable("id") Long id) {
    categoryService.deleteCategory(id);
    return CommonResponse.ok(null, null);
  }
}
