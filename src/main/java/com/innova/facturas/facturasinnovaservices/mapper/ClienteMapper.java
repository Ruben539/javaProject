package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.ClienteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;

public class ClienteMapper {

    public static ClienteDto mapToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getIdCliente(),
                cliente.getEmpresa(),
                cliente.getRuc(),
                cliente.getNombreCliente(),
                cliente.getRucCliente(),
                cliente.getDvRucCliente(),
                cliente.getDireccionCliente(),
                cliente.getTelefonoCliente(),
                cliente.getCorreoCliente(),
                cliente.getEstadoCliente(),
                cliente.getFechaCierreCliente(),
                cliente.getCreatedAt(),
                cliente.getCreatedBy(),
                cliente.getUpdatedAt(),
                cliente.getUpdatedBy());
    }

    public static Cliente mapToCliente(ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getIdCliente(),
                clienteDto.getEmpresa(),
                clienteDto.getRuc(),
                clienteDto.getNombreCliente(),
                clienteDto.getRucCliente(),
                clienteDto.getDvRucCliente(),
                clienteDto.getDireccionCliente(),
                clienteDto.getTelefonoCliente(),
                clienteDto.getCorreoCliente(),
                clienteDto.getEstadoCliente(),
                clienteDto.getFechaCierreCliente(),
                clienteDto.getCreatedAt(),
                clienteDto.getCreatedBy(),
                clienteDto.getUpdatedAt(),
                clienteDto.getUpdatedBy());
    }

}
