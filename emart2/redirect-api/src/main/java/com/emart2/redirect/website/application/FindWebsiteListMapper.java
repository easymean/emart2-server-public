package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.WebsiteListDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FindWebsiteListMapper {
  FindWebsiteListMapper INSTANCE = Mappers.getMapper(FindWebsiteListMapper.class);

  List<WebsiteListDto.Response> toDto(List<WebsiteEntity> list);
}
