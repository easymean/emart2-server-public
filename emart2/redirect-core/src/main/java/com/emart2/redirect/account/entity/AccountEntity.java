package com.emart2.redirect.account.entity;

import com.emart2.redirect.common.BaseEntity;
import com.emart2.redirect.type.AccountType;
import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.website.entity.WebsiteEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200, nullable = false)
  @Setter
  private String accountId;

  @Column(length = 200, nullable = false)
  @Setter
  private String accountPassword;

  @Column
  @Setter
  @Enumerated(EnumType.STRING)
  private AccountType gubun; // PUBLIC OR PRIVATE

  @ManyToOne @Setter
  @JoinColumn(name="userId")
  private UserEntity user;

  @Setter
  private String info;

  public AccountEntity() {
    super();
  }

  @Builder
  public AccountEntity(String accountId, String accountPassword, UserEntity user) {
    super();
    this.accountId = accountId;
    this.accountPassword = accountPassword;
    this.user = user;
  }

}
