package com.emart2.redirect.user.entity;

import com.emart2.redirect.account.entity.AccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class UserEntity {

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
  private String role;

  @OneToMany
  private List<AccountEntity> accountList = new ArrayList<>();

  public UserEntity() {
  }

  @Builder
  public UserEntity(String username, String email, String password, String role) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public void addAccount(AccountEntity accountEntity) {
    this.accountList.add(accountEntity);
  }

  public void encodePassword(PasswordEncoder passwordEncoder){
    this.password = passwordEncoder.encode(this.password);
  }

}
