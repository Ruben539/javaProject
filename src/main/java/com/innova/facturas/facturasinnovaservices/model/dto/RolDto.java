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
public class RolDto implements Serializable {

    private Integer idRol;
    private String nombreRol;
    private String statusRol;
    @CreationTimestamp
    private Timestamp createdAt;
    private Integer createdBy;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private Integer updatedBy;

}
