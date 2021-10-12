package com.emart2.redirect.website.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String name;
    private String description;


    @Builder
    public Response(Long id, String name, String description) {
      this.id = id;
      this.name = name;
      this.description = description;
    }
  }
}
