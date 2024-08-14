package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;
import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class FacturaDto implements Serializable {

    private Integer idFactura;
    private Empresa empresa;
    private String tipoFactura;
    private String timbradoFactura;
    private String cdcFactura;
    private String codigoControlFactura;
    private String numeroFactura;
    private String rucEmisorFactura;
    private String razonSocialEmisorFactura;
    private String rucReceptorFactura;
    private String razonSocialReceptorFactura;
    private String condicionVentaFactura;
    private Date fechaInicioVigenciaFactura;
    private Date fechaFinVigenciaFactura;
    private Date fechaEmisionFactura;
    private Double montoTotalFacturaGs;
    private Double montoTotalIvaFacturaGs;
    private Double montoCincoFacturaGs;
    private Double montoDiezFacturaGs;
    private Double exentaFacturaGs;
    private Double gravadaCincoGs;
    private Double gravadaDiezGs;
    private Double gravadaExentaGs;
    private String statusFactura;
    private String monedaExtranjera;
    private Integer tipoRegistro;
    private Integer tipoComprobante;
    private String detalleComprobante;
    private Integer tipoDocumento;
    private String imputaIva;
    private String imputaIre;
    private String imputaIrpRsp;
    private String comprobanteAsociado;
    private String timbradoComprobanteAsociado;
    private String statusSet;
    private Integer rg90Generado;
    private Integer contadorRg90;
    private Cliente cliente;
    private String tipoMoneda;
    private Double cotizacionCompra;
    private Double cotizacionVenta;
    private Double gravadaExentaMoneda;
    private Double gravadaCincoMoneda;
    private Double gravadaDiezMoneda;
    private Double totalGravadaMoneda;
    private Double exentaMoneda;
    private Double ivaCincoMoneda;
    private Double ivaDiezMoneda;
    private Double totalIvaMoneda;
    @CreationTimestamp
    private Date createdAt;
    private User createdBy;
    @UpdateTimestamp
    private Date updatedAt;
    private User updatedBy;

}
