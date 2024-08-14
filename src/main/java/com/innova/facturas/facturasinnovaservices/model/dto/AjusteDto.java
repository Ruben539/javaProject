package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;

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
public class AjusteDto implements Serializable {

    private Integer idAjuste;
    private Empresa empresa;
    private String nombreAjuste;
    private String acronimo;
    private String descripcion;
    private String status;
    private Integer createdBy;
    @CreationTimestamp
    private Date createdAt;
    private Integer updatedBy;
    @UpdateTimestamp
    private Date updatedAt;
}
