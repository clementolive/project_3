package com.project3.mappers;

import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

   // UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target="email", source="user.email")
    @Mapping(target="name", source="user.name")
    UserDTO userToUserDTO(User user);


    User userDTOToUser(UserDTO userDTO);
}
