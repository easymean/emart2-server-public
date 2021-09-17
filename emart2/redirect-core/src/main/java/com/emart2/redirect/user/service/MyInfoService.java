package com.emart2.redirect.user.service;

import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.exception.UserNotFoundException;
import com.emart2.redirect.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MyInfoService {

  private final UserRepository userRepository;

  public MyInfoService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserEntity getMyInfo(Long id){
    return userRepository.findById(id)
        .orElseThrow(UserNotFoundException::new);
  }
}
