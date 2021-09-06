package com.emart2.redirect.auth;

import com.emart2.redirect.user.entity.UserEntity;
import com.emart2.redirect.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
      throw new UsernameNotFoundException("id에 해당하는 user가 존재하지 않습니다.");
    }
    return new UserAccount(user);
  }

  public UserAccount login(String username, String password){
    UserEntity user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("id에 해당하는 user가 존재하지 않습니다.");
    }
    if(!passwordEncoder.matches(password, user.getPassword())){
      throw new UsernameNotFoundException("id가 존재하지 않거나 비밀번호가 틀렸습니다.");
    }
    return new UserAccount(user);
  }

  public UserEntity createUser(UserEntity user) {
    user.encodePassword(passwordEncoder);
    user.setRole("USER");
    return userRepository.save(user);
  }
}
