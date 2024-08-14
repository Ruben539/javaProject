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
public class PersonaDto implements Serializable {

    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String telefonoPersona;
    private String ciPersona;
    private String statusPersona;
    private Integer createdBy;
    @CreationTimestamp
    private Timestamp createdAt;
    private Integer updatedBy;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
