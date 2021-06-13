package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.CategoryManager;
import com.emart2.redirect.website.dto.CreateCategoryRequest;
import com.emart2.redirect.website.dto.UpdateCategoryRequest;
import com.emart2.redirect.website.dto.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/categories")
public class ManageCategoryController {

  private final CategoryManager categoryManager;

  public ManageCategoryController(CategoryManager categoryManager) {
    this.categoryManager = categoryManager;
  }

  @GetMapping("/{id}")
  public CommonResponse<CategoryResponse> getCategoryById(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", categoryManager.findCategory(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CommonResponse<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
    return CommonResponse.ok("success", categoryManager.createCategory(request));
  }

  @PutMapping("/{id}")
  public CommonResponse<CategoryResponse> updateCategory(@PathVariable("id") Long id, @RequestBody UpdateCategoryRequest request) {
    return CommonResponse.ok("success", categoryManager.updateCategory(id, request));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<Void> deleteCategory(@PathVariable("id") Long id) {
    categoryManager.deleteCategory(id);
    return CommonResponse.ok();
  }
}
