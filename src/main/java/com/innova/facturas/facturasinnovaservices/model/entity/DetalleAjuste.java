package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "detalle_ajuste")
public class DetalleAjuste implements Serializable {

    @Id
    @Column(name = "id_detalle_ajuste")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleAjuste;

    @OneToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ajuste", nullable = false)
    private Ajuste ajuste;

    @Column(name = "etiqueta")
    private String etiqueta;

    @Column(name = "acronimo")
    private String acronimo;

    @Column(name = "valor_entrada")
    private Double valorEntrada;

    @Column(name = "valor_salida")
    private Double valorSalida;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}
