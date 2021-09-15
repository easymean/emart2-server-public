package com.emart2.redirect.user.application.Mapper;


import com.emart2.redirect.user.dto.ManageUserDto;
import com.emart2.redirect.website.entity.WebsiteUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManageUserMapper {

  WebsiteUserEntity toEntity(ManageUserDto.Create dto);

  WebsiteUserEntity toEntity(ManageUserDto.Update dto);

  @Mapping(source = "colOrder", target = "order")
  ManageUserDto.Response toDto(WebsiteUserEntity WebsiteUserEntity);

}
