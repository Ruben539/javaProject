package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class ClienteDto implements Serializable {

    private Integer idCliente;
    private Empresa empresa;
    private String ruc;
    private String nombreCliente;
    private String rucCliente;
    private String dvRucCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String correoCliente;
    private String estadoCliente;
    private Integer fechaCierreCliente;
    @CreationTimestamp
    private Timestamp createdAt;
    private Integer createdBy;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private Integer updatedBy;

}
