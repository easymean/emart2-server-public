package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.CategoryFinder;
import com.emart2.redirect.website.dto.CategoryListResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class FindCategoryListController {

  private final CategoryFinder categoryFinder;

  public FindCategoryListController(CategoryFinder categoryFinder) {
    this.categoryFinder = categoryFinder;
  }

  @GetMapping
  public CommonResponse<CategoryListResponse> getCategoryList() {
    return CommonResponse.ok("success", categoryFinder.findCategoryList());
  }

}
