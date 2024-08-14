package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.AjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;

public class AjusteMapper {

    public static AjusteDto mapToAjustesDto(Ajuste ajuste) {
        return new AjusteDto(
                ajuste.getIdAjuste(),
                ajuste.getEmpresa(),
                ajuste.getNombreAjuste(),
                ajuste.getAcronimo(),
                ajuste.getDescripcion(),
                ajuste.getStatus(),
                ajuste.getCreatedBy(),
                ajuste.getCreatedAt(),
                ajuste.getUpdatedBy(),
                ajuste.getUpdatedAt());
    }

    public static Ajuste mapToAjuste(AjusteDto ajusteDto) {
        return new Ajuste(
                ajusteDto.getIdAjuste(),
                ajusteDto.getEmpresa(),
                ajusteDto.getNombreAjuste(),
                ajusteDto.getAcronimo(),
                ajusteDto.getDescripcion(),
                ajusteDto.getStatus(),
                ajusteDto.getCreatedBy(),
                ajusteDto.getCreatedAt(),
                ajusteDto.getUpdatedBy(),
                ajusteDto.getUpdatedAt());
    }

}
