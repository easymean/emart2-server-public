package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.CreateWebsiteRequest;
import com.emart2.redirect.website.dto.UpdateWebsiteRequest;
import com.emart2.redirect.website.dto.WebsiteResponse;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WebsiteMapper {
  WebsiteMapper INSTANCE = Mappers.getMapper(WebsiteMapper.class);

  @Mapping(target = "categoryId", ignore = true)
  WebsiteEntity toEntity(CreateWebsiteRequest dto);

  @Mapping(target = "categoryId", ignore = true)
  WebsiteEntity toEntity(UpdateWebsiteRequest dto);

  WebsiteResponse toDto(WebsiteEntity category);

  List<WebsiteResponse> toDto(List<WebsiteEntity> list);
}
