package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.CategoryManager;
import com.emart2.redirect.website.dto.ManageCategoryDto;
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
  public CommonResponse<ManageCategoryDto.Response> getCategoryById(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", categoryManager.findCategory(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CommonResponse<ManageCategoryDto.Response> createCategory(@RequestBody ManageCategoryDto.Create request) {
    return CommonResponse.ok("success", categoryManager.createCategory(request));
  }

  @PutMapping("/{id}")
  public CommonResponse<ManageCategoryDto.Response> updateCategory(@PathVariable("id") Long id,
                                                                   @RequestBody ManageCategoryDto.Update request) {
    return CommonResponse.ok("success", categoryManager.updateCategory(id, request));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<Void> deleteCategory(@PathVariable("id") Long id) {
    categoryManager.deleteCategory(id);
    return CommonResponse.ok();
  }
}
