package com.emart2.redirect.website.dto;

import com.emart2.redirect.type.StageType;
import lombok.*;

public class ManageWebsiteDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {

    private Long id;
    private String name;
    private String description;
    private String url;
    private StageType stage;
    private boolean dev;

    @Builder
    public Response(Long id, String name, String description, String url, StageType stage, boolean dev) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.url = url;
      this.stage = stage;
      this.dev = dev;
    }
  }

  @Getter
  public static class Create {
    private final String name;
    private final String description;
    private final String url;
    private final StageType stage;
    private final Long categoryId;
    private final boolean dev;

    @Builder
    public Create(String name, String description, String url, StageType stage, Long categoryId, boolean dev) {
      this.name = name;
      this.description = description;
      this.url = url;
      this.stage = stage;
      this.categoryId = categoryId;
      this.dev = dev;
    }
  }

  @Getter
  public static class Update {
    private final String name;
    private final String description;
    private final String url;
    private final StageType stage;
    private final Long categoryId;
    private final boolean dev;

    @Builder
    public Update(String name, String description, String url, StageType stage, Long categoryId, boolean dev) {
      this.name = name;
      this.description = description;
      this.url = url;
      this.stage = stage;
      this.categoryId = categoryId;
      this.dev = dev;
    }
  }
}
