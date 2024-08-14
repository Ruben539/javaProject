package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class AuditoriaDto implements Serializable {

    private Integer idAuditoria;
    private String tablaAfectada;
    @CreationTimestamp
    private Timestamp fechaCreacion;
    private String creadoPor;
    private String accion;
    private String accionDetalle;
    private String detalle;

}
