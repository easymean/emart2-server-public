package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.common.CommonMapper;
import com.emart2.redirect.user.entity.UserEntity;
import org.mapstruct.Mapping;

public interface LoginMapper extends CommonMapper {
  @Mapping(target = "role", ignore = true)
  UserEntity toEntity(LoginDto.Login req);

}
