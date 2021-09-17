package com.emart2.redirect.user.application;

import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MyInfoMapper {

  @Mapping(source="username", target="userId")
  MyInfoDto.Response toDto(UserEntity user);
}
