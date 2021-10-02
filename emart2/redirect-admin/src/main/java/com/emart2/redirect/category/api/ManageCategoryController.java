package com.emart2.redirect.category.api;

import com.emart2.redirect.category.application.CategoryManager;
import com.emart2.redirect.category.dto.ManageCategoryDto;
import com.emart2.redirect.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class ManageCategoryController {

  private final CategoryManager categoryManager;

  public ManageCategoryController(CategoryManager categoryManager) {
    this.categoryManager = categoryManager;
  }

  @GetMapping()
  public CommonResponse<List<ManageCategoryDto.Response>> getCategories(){
    return CommonResponse.ok("success", categoryManager.findCategoryList());
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
