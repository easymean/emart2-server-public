package com.example.emart2.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity @Table(name = "category")
public class Category extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length=50, nullable = false)
  @Setter
  private String name;

  @Column(columnDefinition = "TEXT")
  @Setter
  private String description;

  @Setter
  @Column(nullable = false)
  private int colOrder;

  @OneToMany(mappedBy = "category")
  private Set<Website> websites = new HashSet<>();

  public void addWebsite(Website website){
    this.getWebsites().add(website);
    website.setCategory(this);
  }

  @Builder
  public Category(String name, String description){
    super();
    this.name = name;
    this.description = description;
    this.colOrder = 0;
  }

  public Category(){
    super();
    this.colOrder = 0;
  }

}
