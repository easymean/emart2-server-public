package com.example.emart2.type.mapper;

import com.example.emart2.redirect.dto.WebsiteRequest;
import com.example.emart2.redirect.dto.WebsiteResponse;
import com.example.emart2.redirect.entity.Website;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WebsiteMapper {

  Website toEntity(WebsiteRequest dto);

  WebsiteResponse toDto(Website category);

  List<WebsiteResponse> toDto(List<Website> list);
}
