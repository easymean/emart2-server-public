package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.CategoryListFinder;
import com.emart2.redirect.website.dto.CategoryListDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class FindCategoryListController {

  private final CategoryListFinder categoryListFinder;

  public FindCategoryListController(CategoryListFinder categoryListFinder) {
    this.categoryListFinder = categoryListFinder;
  }

  @GetMapping
  public CommonResponse<CategoryListDto> getCategoryList() {
    return CommonResponse.ok("success", categoryListFinder.findCategoryList());
  }

}
