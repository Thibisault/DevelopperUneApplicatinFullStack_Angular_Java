package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    ThemeDto toDto(Theme theme);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Theme toEntity(ThemeDto dto);

    List<ThemeDto> toDtoList(List<Theme> themes);

    List<Theme> toEntityList(List<ThemeDto> dtos);

}
