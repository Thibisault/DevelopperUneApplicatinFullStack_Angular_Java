//path: back/src/main/java/com/openclassrooms/mddapi/dto/DBUserMapper.java
package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.DBUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DBUserMapper {

    DBUserMapper INSTANCE = Mappers.getMapper(DBUserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "role", target = "role")
    DBUserDTO toDTO(DBUser dbUser);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "role", target = "role")
    DBUser toEntity(DBUserDTO dbUserDTO);

    List<DBUserDTO> toDTOList(List<DBUser> dbUserList);

    List<DBUser> toEntityList(List<DBUserDTO> dbUserDTOList);
}