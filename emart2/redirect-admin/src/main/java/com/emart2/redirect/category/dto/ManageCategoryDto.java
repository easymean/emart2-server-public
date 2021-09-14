package com.emart2.redirect.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ManageCategoryDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {

    private Long id;
    private String name;
    private String description;
    private int order;

    @Builder
    public Response(Long id, String name, String description, int order) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.order = order;
    }
  }

  @Getter
  public static class Create {
    private final String name;
    private final String description;

    public Create(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }

  @Getter
  public static class Update {
    private final String name;
    private final String description;

    public Update(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }
}
