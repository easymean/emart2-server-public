package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.CategoryFinder;
import com.emart2.redirect.website.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class FindCategoryController {

  private final CategoryFinder categoryFinder;

  public FindCategoryController(CategoryFinder categoryFinder) {
    this.categoryFinder = categoryFinder;
  }

  @GetMapping
  public CommonResponse<List<CategoryDto.Response>> getCategoryList() {
    return CommonResponse.ok("success", categoryFinder.findCategoryList());
  }

  @GetMapping("/{id}")
  public CommonResponse<CategoryDto.Response> getCategoryById(@PathVariable("id") Long id) {
    return CommonResponse.ok("success", categoryFinder.findCategory(id));
  }

}
