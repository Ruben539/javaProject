package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.UserDto;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getIdUser(),
                user.getIdEmpresa(),
                user.getRol(),
                user.getUsername(),
                user.getPassword(),
                user.getLastLogin(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getPersona(),
                user.getStatusUser(),
                user.getCreatedBy());
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getIdUser(),
                userDto.getIdEmpresa(),
                userDto.getRol(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getLastLogin(),
                userDto.getCreatedAt(),
                userDto.getUpdatedAt(),
                userDto.getPersona(),
                userDto.getStatusUser(),
                userDto.getCreatedBy());
    }

}
