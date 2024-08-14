package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.HistorialinformesDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Historialinformes;

public class HistorialinformesMapper {

    public static HistorialinformesDto mapToHistorialDto(Historialinformes historial) {
        return new HistorialinformesDto(
                historial.getIdHistorial(),
                historial.getStatusHistorial(),
                historial.getUser(),
                historial.getCreatedAt(),
                historial.getUpdatedAt(),
                historial.getDatos(),
                historial.getPeriodo(),
                historial.getCliente());
    }

    public static Historialinformes mapHistorial(HistorialinformesDto historialDto) {
        return new Historialinformes(
                historialDto.getIdHistorial(),
                historialDto.getStatusHistorial(),
                historialDto.getUser(),
                historialDto.getCreatedAt(),
                historialDto.getUpdatedAt(),
                historialDto.getDatos(),
                historialDto.getPeriodo(),
                historialDto.getCliente());
    }

}
