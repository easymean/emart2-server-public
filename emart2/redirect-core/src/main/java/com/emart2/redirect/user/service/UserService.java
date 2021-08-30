package com.emart2.redirect.user.service;

import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

}
