package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class EmpresaDto implements Serializable {

    private Integer idEmpresa;
    private String nombreEmpresa;
    private String rucEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String correoEmpresa;
    private String statusEmpresa;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

}
