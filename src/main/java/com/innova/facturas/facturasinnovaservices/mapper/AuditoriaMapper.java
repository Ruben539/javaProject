package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.AuditoriaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Auditoria;

public class AuditoriaMapper {
    public static AuditoriaDto mapToAuditoriaDto(Auditoria auditoria) {
        return new AuditoriaDto(
                auditoria.getIdAuditoria(),
                auditoria.getTablaAfectada(),
                auditoria.getFechaCreacion(),
                auditoria.getCreadoPor(),
                auditoria.getAccion(),
                auditoria.getAccionDetalle(),
                auditoria.getDetalle());
    }

    public static Auditoria mapToAuditoria(AuditoriaDto auditoriaDto) {
        return new Auditoria(
                auditoriaDto.getIdAuditoria(),
                auditoriaDto.getTablaAfectada(),
                auditoriaDto.getFechaCreacion(),
                auditoriaDto.getCreadoPor(),
                auditoriaDto.getAccion(),
                auditoriaDto.getAccionDetalle(),
                auditoriaDto.getDetalle());
    }
}
