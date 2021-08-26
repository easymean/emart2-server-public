package com.emart2.redirect.user.service;

import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserEntity createUser(UserEntity user) {
    user.encodePassword(passwordEncoder);
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUserId(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return UserEntity.builder()
        .userId(user.getUserId())
        .password(user.getPassword())
        .role(user.getRole())
        .build();
  }
}
