package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "auditoria")
public class Auditoria implements Serializable {

    @Id
    @Column(name = "id_auditoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuditoria;

    @Column(name = "tabla_afectada")
    private String tablaAfectada;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "accion")
    private String accion;

    @Column(name = "accion_detalle")
    private String accionDetalle;

    @Column(name = "detalle")
    private String detalle;

}
