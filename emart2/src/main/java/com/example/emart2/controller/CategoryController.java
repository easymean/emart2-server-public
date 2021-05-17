package com.example.emart2.controller;

import com.example.emart2.common.CommonResponse;
import com.example.emart2.dto.CategoryDto;
import com.example.emart2.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController("/category")
public class CategoryController {

  CategoryService categoryService;
  public CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
  }


  @GetMapping("/{id}")
  public CommonResponse<CategoryDto.Response> getCategoryById(@PathVariable("id") Long id){
    return CommonResponse.ok("success", categoryService.findById(id));
  }

  @GetMapping("/")
  public CommonResponse<CategoryDto.Response> getCategoryList(){
    return CommonResponse.ok("success", categoryService.getList());
  }

  @PostMapping("/")
  public CommonResponse<CategoryDto.Response> createCategory(@RequestBody CategoryDto.Request request){
    return CommonResponse.ok("success", categoryService.createCategory(request));
  }

  @PutMapping("/{id}")
  public CommonResponse<CategoryDto.Response> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto.Request request){
    return CommonResponse.ok("success", categoryService.updateCategory(id, request));
  }

  @DeleteMapping("/{id}")
  public CommonResponse<CategoryDto.Response> deleteCategory(@PathVariable("id") Long id){
    categoryService.deleteCategory(id);
    return CommonResponse.ok(null,null );
  }
}
