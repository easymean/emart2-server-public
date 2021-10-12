package com.emart2.redirect.website.entity;

import com.emart2.redirect.common.entity.BaseEntity;
import com.emart2.redirect.type.StageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "website")
public class WebsiteEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  @Setter
  private String name;

  @Column(columnDefinition = "TEXT")
  @Setter
  private String description;

  @Column(columnDefinition = "TEXT")
  @Setter
  private String url;

  @Column
  private int frequency;

  @Column
  @Setter
  @Enumerated(EnumType.STRING)
  private StageType stage;

  @Column
  @Setter
  private boolean dev;

  @Column
  @Setter
  private String categoryName;

  @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoryId")
  private WebsiteCategoryEntity category;


  @Builder
  public WebsiteEntity(String name, String description, String url, StageType stage, boolean dev) {
    super();
    this.name = name;
    this.description = description;
    this.url = url;
    this.frequency = 0;
    this.stage = stage;
    this.dev = dev;
  }

  public WebsiteEntity() {
    super();
  }

  @Override
  public String toString() {
    return "{" +
        "name: " + name +
        "description: " + description +
        "}";
  }

}
