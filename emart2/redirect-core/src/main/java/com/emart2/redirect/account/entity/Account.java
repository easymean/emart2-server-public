package com.emart2.redirect.account.entity;

import com.emart2.redirect.common.BaseEntity;
import com.emart2.redirect.website.entity.WebsiteCategoryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "account")
public class Account extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200, nullable = false)
  @Setter
  private String accountId;

  @Column(length = 200, nullable = false)
  @Setter
  private String accountPassword;

  @Setter
  @ManyToOne
  private WebsiteCategoryEntity websiteCategoryEntity;

  public Account() {
    super();
  }

  @Builder
  public Account(String accountId, String accountPassword, WebsiteCategoryEntity websiteCategoryEntity) {
    super();
    this.accountId = accountId;
    this.accountPassword = accountPassword;
    this.websiteCategoryEntity = websiteCategoryEntity;
  }

}
