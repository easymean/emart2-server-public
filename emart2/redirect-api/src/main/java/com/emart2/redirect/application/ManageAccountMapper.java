package com.emart2.redirect.application;

import com.emart2.redirect.account.dto.ManageAccountDto;
import com.emart2.redirect.account.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManageAccountMapper {
  AccountEntity toEntity(ManageAccountDto.Request req);
  ManageAccountDto.Response toDto(AccountEntity account);
}
