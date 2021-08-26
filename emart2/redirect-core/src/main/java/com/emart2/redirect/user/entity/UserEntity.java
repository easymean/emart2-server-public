package com.emart2.redirect.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String userId;
  private String password;
  private String email;
  private String role;

  @Builder
  public UserEntity(String userId, String password, String role) {
    this.userId = userId;
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
    return userId;
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
