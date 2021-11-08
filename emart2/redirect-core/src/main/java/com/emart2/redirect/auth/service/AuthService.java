package com.emart2.redirect.auth.service;

import com.emart2.redirect.auth.exception.UserAlreadyExistException;
import com.emart2.redirect.auth.exception.UsernameNotFoundException;
import com.emart2.redirect.auth.exception.WrongPasswordException;
import com.emart2.redirect.user.entity.User;
import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService{

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User login(String username, String password){
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException();
    }
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new WrongPasswordException();
    }
    return user;
  }

  public UserEntity getUserByUsername(String username) throws UsernameNotFoundException{
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException();
    }
    return user;
  }

  public UserEntity createUser(UserEntity user) {
    if(checkId(user.getUsername())){
      throw new UserAlreadyExistException();
    }
    user.encodePassword(passwordEncoder);
    return userRepository.save(user);
  }

  public Boolean checkId(String id) {
    return userRepository.existsUserEntitiesByUsername(id);
  }
}
