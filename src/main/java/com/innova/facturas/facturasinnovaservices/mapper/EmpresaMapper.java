package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.EmpresaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

public class EmpresaMapper {

    public static EmpresaDto mapToEmpresaDto(Empresa empresa) {
        return new EmpresaDto(
                empresa.getIdEmpresa(),
                empresa.getNombreEmpresa(),
                empresa.getRucEmpresa(),
                empresa.getDireccionEmpresa(),
                empresa.getTelefonoEmpresa(),
                empresa.getCorreoEmpresa(),
                empresa.getStatusEmpresa(),
                empresa.getCreatedAt(),
                empresa.getUpdatedAt(),
                empresa.getCreatedBy(),
                empresa.getUpdatedBy());
    }

    public static Empresa mapToEmpresa(EmpresaDto empresaDto) {
        return new Empresa(
                empresaDto.getIdEmpresa(),
                empresaDto.getNombreEmpresa(),
                empresaDto.getRucEmpresa(),
                empresaDto.getDireccionEmpresa(),
                empresaDto.getTelefonoEmpresa(),
                empresaDto.getCorreoEmpresa(),
                empresaDto.getStatusEmpresa(),
                empresaDto.getCreatedAt(),
                empresaDto.getUpdatedAt(),
                empresaDto.getCreatedBy(),
                empresaDto.getUpdatedBy());
    }

}
