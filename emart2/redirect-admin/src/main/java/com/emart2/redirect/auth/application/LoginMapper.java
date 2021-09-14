package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoginMapper {
  @Mapping(target = "email", ignore = true)
  UserEntity toEntity(LoginDto.Login req);
  
  UserEntity toEntity(LoginDto.Signup req);

  LoginDto.Response toDto(UserEntity user);
}
