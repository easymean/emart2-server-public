package com.emart2.redirect.user.entity;

import com.emart2.redirect.account.entity.AccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String email;
  private String password;

  @Setter
  private String role;

  @OneToMany
  private List<AccountEntity> accountList;

  public void addAccount(AccountEntity accountEntity){
    this.accountList.add(accountEntity);
  }


  public UserEntity() {
  }

  @Builder
  public UserEntity(String email, String password, String role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public void encodePassword(PasswordEncoder passwordEncoder) {
    this.password = passwordEncoder.encode(this.password);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
