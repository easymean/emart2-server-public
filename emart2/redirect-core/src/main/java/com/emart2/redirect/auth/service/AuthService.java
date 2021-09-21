package com.emart2.redirect.auth.service;

import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.auth.exception.UsernameNotFoundException;
import com.emart2.redirect.auth.exception.WrongPasswordException;
import com.emart2.redirect.type.ErrorType;
import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException();
    }
    return new UserAccount(user);
  }

  public UserAccount login(String username, String password) {
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException();
    }
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new WrongPasswordException();
    }
    return new UserAccount(user);
  }

  public UserEntity createUser(UserEntity user) {
    user.encodePassword(passwordEncoder);
    return userRepository.save(user);
  }

  public Boolean checkId(String id) {
    return userRepository.existsUserEntitiesByUsername(id);
  }
}
