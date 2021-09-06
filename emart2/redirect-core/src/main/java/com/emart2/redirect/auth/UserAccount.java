package com.emart2.redirect.auth;

import com.emart2.redirect.user.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserAccount extends User {

  private final UserEntity user;

  public UserAccount(UserEntity user) {
    super(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    this.user = user;
  }

  public UserEntity getUser() {
    return user;
  }
}
