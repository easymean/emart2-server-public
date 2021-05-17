package com.example.emart2.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class CategoryDto {

  @Builder
  public static class Responses{
    private List<Response> categoryList;
  }

  @Getter
  @Builder
  public static class Response{
    private Long id;
    private String name;
    private String description;
    private int order;

  }

  @Getter
  public static class Request{
    private String name;
    private String description;
  }


}
