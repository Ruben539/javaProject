package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class DetalleAjusteDto implements Serializable {

    private Integer idDetalleAjuste;
    private Ajuste ajuste;
    private String etiqueta;
    private String acronimo;
    private Double valorEntrada;
    private Double valorSalida;
    private String status;
    private Integer createdBy;
    @CreationTimestamp
    private Date createdAt;
    private Integer updatedBy;
    @UpdateTimestamp
    private Date updatedAt;

}
