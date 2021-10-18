package com.emart2.redirect.user.service;

import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.exception.UserNotFoundException;
import com.emart2.redirect.user.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void approveUser(Long id){
    UserEntity user = userRepository.findByIdAndIsActiveIsTrue(id);
    if(user == null){
      throw new UserNotFoundException();
    }

    user.setAuthStatus(true);
  }

}
