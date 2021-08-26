package com.emart2.redirect.website.application;

import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManageWebsiteMapper {

  WebsiteEntity toEntity(ManageWebsiteDto.Create dto);

  WebsiteEntity toEntity(ManageWebsiteDto.Update dto);

  ManageWebsiteDto.Response toDto(WebsiteEntity category);
}
