package com.emart2.redirect.website.entity;

import com.emart2.redirect.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "category")
public class WebsiteCategoryEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  @Setter
  private String name;

  @Column(columnDefinition = "TEXT")
  @Setter
  private String description;

  @Setter
  @Column(nullable = false)
  private int colOrder;

  @OneToMany(mappedBy = "category")
  private Set<WebsiteEntity> websiteEntities = new HashSet<>();

  public void addWebsite(WebsiteEntity websiteEntity) {
    this.getWebsiteEntities().add(websiteEntity);
    websiteEntity.setCategory(this);
  }

  @Builder
  public WebsiteCategoryEntity(String name, String description) {
    super();
    this.name = name;
    this.description = description;
    this.colOrder = 0;
  }

  public WebsiteCategoryEntity() {
    super();
    this.colOrder = 0;
  }

}
