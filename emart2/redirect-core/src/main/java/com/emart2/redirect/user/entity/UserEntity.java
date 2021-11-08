package com.emart2.redirect.user.entity;

import com.emart2.redirect.account.entity.AccountEntity;
import com.emart2.redirect.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user") @NoArgsConstructor
public class UserEntity extends BaseEntity implements User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String username;

  @Setter
  private String email;

  @Setter
  private String password;

  @Setter
  private Boolean authStatus;

  @Setter
  private String role;

  @OneToMany
  private List<AccountEntity> accountList = new ArrayList<>();

  @Builder
  public UserEntity(String username, String email, String password, String role) {
    super();
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
    this.authStatus = false;
  }

  public void addAccount(AccountEntity accountEntity) {
    this.accountList.add(accountEntity);
  }

  public void encodePassword(PasswordEncoder passwordEncoder) {
    this.password = passwordEncoder.encode(this.password);
  }

}
