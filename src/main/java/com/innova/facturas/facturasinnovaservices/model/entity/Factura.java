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
import jakarta.persistence.ManyToOne;
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
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @Column(name = "tipo_factura")
    private String tipoFactura;

    @Column(name = "timbrado_factura")
    private String timbradoFactura;

    @Column(name = "cdc_factura")
    private String cdcFactura;

    @Column(name = "codigo_control_factura")
    private String codigoControlFactura;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "ruc_emisor_factura")
    private String rucEmisorFactura;

    @Column(name = "razon_social_emisor_factura")
    private String razonSocialEmisorFactura;

    @Column(name = "ruc_receptor_factura")
    private String rucReceptorFactura;

    @Column(name = "razon_social_receptor_factura")
    private String razonSocialReceptorFactura;

    @Column(name = "condicion_venta_factura")
    private String condicionVentaFactura;

    @Column(name = "fecha_inicio_vigencia_factura")
    private Date fechaInicioVigenciaFactura;

    @Column(name = "fecha_fin_vigencia_factura")
    private Date fechaFinVigenciaFactura;

    @Column(name = "fecha_emision_factura")
    private Date fechaEmisionFactura;

    @Column(name = "monto_total_factura")
    private Double montoTotalFacturaGs;

    @Column(name = "monto_total_iva_factura")
    private Double montoTotalIvaFacturaGs;

    @Column(name = "monto_5_factura")
    private Double montoCincoFacturaGs;

    @Column(name = "monto_10_factura")
    private Double montoDiezFacturaGs;

    @Column(name = "exenta_factura")
    private Double exentaFacturaGs;

    @Column(name = "gravada_5")
    private Double gravadaCincoGs;

    @Column(name = "gravada_10")
    private Double gravadaDiezGs;

    @Column(name = "gravada_exenta")
    private Double gravadaExentaGs;

    @Column(name = "status_factura")
    private String statusFactura;

    @Column(name = "moneda_extranjera")
    private String monedaExtranjera;

    @Column(name = "tipo_registro")
    private Integer tipoRegistro;

    @Column(name = "tipo_comprobante")
    private Integer tipoComprobante;

    @Column(name = "detalle_comprobante")
    private String detalleComprobante;

    @Column(name = "tipo_documento")
    private Integer tipoDocumento;

    @Column(name = "imputa_iva")
    private String imputaIva;

    @Column(name = "imputa_ire")
    private String imputaIre;

    @Column(name = "imputa_irp_rsp")
    private String imputaIrpRsp;

    @Column(name = "comprobante_asociado")
    private String comprobanteAsociado;

    @Column(name = "timbrado_comprobante_asociado")
    private String timbradoComprobanteAsociado;

    @Column(name = "status_set")
    private String statusSet;

    @Column(name = "id_rg90_generado")
    private Integer rg90Generado;

    @Column(name = "contador_rg90")
    private Integer contadorRg90;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "tipo_moneda")
    private String tipoMoneda;

    @Column(name = "cotizacion_compra")
    private Double cotizacionCompra;

    @Column(name = "cotizacion_venta")
    private Double cotizacionVenta;

    @Column(name = "gravada_exenta_moneda")
    private Double gravadaExentaMoneda;

    @Column(name = "gravada_cinco_moneda")
    private Double gravadaCincoMoneda;

    @Column(name = "gravada_diez_moneda")
    private Double gravadaDiezMoneda;

    @Column(name = "total_gravada_moneda")
    private Double totalGravadaMoneda;

    @Column(name = "exenta_moneda")
    private Double exentaMoneda;

    @Column(name = "iva_cinco_moneda")
    private Double ivaCincoMoneda;

    @Column(name = "iva_diez_moneda")
    private Double ivaDiezMoneda;

    @Column(name = "total_iva_moneda")
    private Double totalIvaMoneda;

    @Column(name = "created_at")
    @CreationTimestamp // with this annotation, hibernate will automatically manage the timestamps
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(name = "updated_at")
    @UpdateTimestamp // with this annotation, hibernate will automatically manage the timestamps
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;

}
