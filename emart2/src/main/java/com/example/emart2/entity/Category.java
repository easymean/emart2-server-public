package com.example.emart2.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity @Table(name = "Category")
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

  @Column(nullable = false)
  private final boolean isActive;

  @Column(length=50, nullable = false)
  private final int order;

  @Builder
  public Category(String name, String description){
    this.name = name;
    this.description = description;
    this.order = 0;
    this.isActive = true;
  }

  public Category(){
    this.isActive = true;
    this.order = 0;
  }

}
