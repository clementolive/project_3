package com.project3.mappers;
import com.project3.dtos.UserDTO;
import com.project3.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="email", source="user.email")
    @Mapping(target="name", source="user.name")
    UserDTO userToUserDTO(User user);
    
    User userDTOToUser(UserDTO userDTO);

    @Mapping(target="email", source="user.username")
    UserDTO userDetailsToUserDTO(UserDetails user);
}
