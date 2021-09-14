package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {

  UserEntity toEntity(LoginDto.Signup req);

  LoginDto.Response toDto(UserEntity user);
}
