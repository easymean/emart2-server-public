package com.emart2.redirect.user.application;

import com.emart2.redirect.user.dto.MyInfoDto;
import com.emart2.redirect.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyInfoMapper {
  MyInfoDto.Response toDto(UserEntity user);
}
