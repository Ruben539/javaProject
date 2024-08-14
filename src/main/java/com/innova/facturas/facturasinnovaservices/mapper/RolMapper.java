package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.RolDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;

public class RolMapper {

    public static RolDto mapToRolDto(Rol rol) {
        return new RolDto(
                rol.getIdRol(),
                rol.getNombreRol(),
                rol.getStatusRol(),
                rol.getCreatedAt(),
                rol.getCreatedBy(),
                rol.getUpdatedAt(),
                rol.getUpdatedBy());
    }

    public static Rol mapToRol(RolDto rolDto) {
        return new Rol(
                rolDto.getIdRol(),
                rolDto.getNombreRol(),
                rolDto.getStatusRol(),
                rolDto.getCreatedAt(),
                rolDto.getCreatedBy(),
                rolDto.getUpdatedAt(),
                rolDto.getUpdatedBy());
    }

}
