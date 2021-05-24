package com.example.emart2.redirect.entity;

import com.example.emart2.type.StageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "website")
public class Website extends BaseEntity {

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
  private boolean isDev;

  @Setter
  @ManyToOne
  private Category category;


  @Builder
  public Website(String name, String description, String url, StageType stage, boolean isDev) {
    super();
    this.name = name;
    this.description = description;
    this.url = url;
    this.frequency = 0;
    this.stage = stage;
    this.isDev = isDev;
  }

  public Website() {
    super();
  }

}
