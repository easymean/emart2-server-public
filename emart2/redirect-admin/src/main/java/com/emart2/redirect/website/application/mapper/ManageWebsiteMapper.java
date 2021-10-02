package com.emart2.redirect.website.application.mapper;

import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ManageWebsiteMapper {

  WebsiteEntity toEntity(ManageWebsiteDto.Create dto);

  WebsiteEntity toEntity(ManageWebsiteDto.Update dto);

  ManageWebsiteDto.Response toDto(WebsiteEntity category);

  List<ManageWebsiteDto.Response> toDto(List<WebsiteEntity> websiteEntityList);
}
