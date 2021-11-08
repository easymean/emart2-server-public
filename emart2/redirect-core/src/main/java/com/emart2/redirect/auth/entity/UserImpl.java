package com.emart2.redirect.auth.entity;

import com.emart2.redirect.user.entity.User;
import com.emart2.redirect.user.entity.UserEntity;
import lombok.Getter;
@Getter
public class UserImpl implements User {

  private final Long id;
  private final String username;

  public UserImpl(UserEntity user){
    this.id = user.getId();
    this.username = user.getUsername();
  }
}
