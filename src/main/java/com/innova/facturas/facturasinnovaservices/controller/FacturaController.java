package com.innova.facturas.facturasinnovaservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.facturas.facturasinnovaservices.exception.MensajeResponse;
import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;
import com.innova.facturas.facturasinnovaservices.services.FacturaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class FacturaController {

        @Autowired
        private FacturaService facturaService;

        @GetMapping("facturas")
        public ResponseEntity<?> showAll() {

                List<Factura> facturas = facturaService.getAllFacturas();

                if (facturas == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(facturas)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(facturas)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("factura/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Factura factura = facturaService.findById(id);

                if (factura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(factura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(factura)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("factura/exists/{timbrado}&{comprobante}&{nro}")
        public ResponseEntity<?> searchInvoice(@PathVariable String timbrado, @PathVariable Integer comprobante,
                        @PathVariable String nro) {

                Factura factura = facturaService.searchInvoice(timbrado, comprobante, nro);

                if (factura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("NO EXISTE")
                                                        .objeto(factura)
                                                        .build(),
                                        HttpStatus.OK);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("EXISTE")
                                                .objeto(factura)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("listPeriodosClientes")
        public ResponseEntity<?> listPeriodosClientes() {

                List<Factura> listPeriodosClientes = facturaService.listPeriodosClientes();

                if (listPeriodosClientes == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(listPeriodosClientes)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(listPeriodosClientes)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("invoiceOfSelectedPeriod/{ruc}&{anho}&{mes}")
        public ResponseEntity<?> invoiceOfSelectedPeriod(@PathVariable String ruc, @PathVariable String anho,
                        @PathVariable String mes) {

                List<Factura> listClientesSeleccionados = facturaService.invoiceOfSelectedPeriod(ruc, anho, mes);

                if (listClientesSeleccionados == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(listClientesSeleccionados)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("ENCONTRADOS")
                                                .objeto(listClientesSeleccionados)
                                                .build(),
                                HttpStatus.OK);
        }

        @PostMapping("factura")
        public ResponseEntity<?> create(@RequestBody FacturaDto facturaDto) {
                Factura facturaSave = null;
                try {
                        facturaSave = facturaService.save(facturaDto);
                        return new ResponseEntity<>(MensajeResponse.builder()
                                        .mensaje("CREADO")
                                        .objeto(FacturaDto.builder()
                                                        .idFactura(null)
                                                        .empresa(facturaSave.getEmpresa())
                                                        .tipoFactura(facturaSave.getTipoFactura())
                                                        .timbradoFactura(facturaSave.getTimbradoFactura())
                                                        .cdcFactura(facturaSave.getCdcFactura())
                                                        .codigoControlFactura(facturaSave.getCodigoControlFactura())
                                                        .numeroFactura(facturaSave.getNumeroFactura())
                                                        .rucEmisorFactura(facturaSave.getRucEmisorFactura())
                                                        .razonSocialEmisorFactura(
                                                                        facturaSave.getRazonSocialEmisorFactura())
                                                        .rucReceptorFactura(facturaSave.getRucReceptorFactura())
                                                        .razonSocialReceptorFactura(
                                                                        facturaSave.getRazonSocialReceptorFactura())
                                                        .condicionVentaFactura(facturaSave.getCondicionVentaFactura())
                                                        .fechaInicioVigenciaFactura(
                                                                        facturaSave.getFechaInicioVigenciaFactura())
                                                        .fechaFinVigenciaFactura(
                                                                        facturaSave.getFechaFinVigenciaFactura())
                                                        .fechaEmisionFactura(facturaSave.getFechaEmisionFactura())
                                                        .montoTotalFacturaGs(facturaSave.getMontoTotalFacturaGs())
                                                        .montoTotalIvaFacturaGs(facturaSave.getMontoTotalIvaFacturaGs())
                                                        .montoCincoFacturaGs(facturaSave.getMontoCincoFacturaGs())
                                                        .montoDiezFacturaGs(facturaSave.getMontoDiezFacturaGs())
                                                        .exentaFacturaGs(facturaSave.getExentaFacturaGs())
                                                        .gravadaCincoGs(facturaSave.getGravadaCincoGs())
                                                        .gravadaDiezGs(facturaSave.getGravadaDiezGs())
                                                        .gravadaExentaGs(facturaSave.getGravadaExentaGs())
                                                        .statusFactura(facturaSave.getStatusFactura())
                                                        .monedaExtranjera(facturaSave.getMonedaExtranjera())
                                                        .tipoRegistro(facturaSave.getTipoRegistro())
                                                        .tipoComprobante(facturaSave.getTipoComprobante())
                                                        .detalleComprobante(facturaSave.getDetalleComprobante())
                                                        .tipoDocumento(facturaSave.getTipoDocumento())
                                                        .imputaIva(facturaSave.getImputaIva())
                                                        .imputaIre(facturaSave.getImputaIre())
                                                        .imputaIrpRsp(facturaSave.getImputaIrpRsp())
                                                        .timbradoComprobanteAsociado(
                                                                        facturaSave.getTimbradoComprobanteAsociado())
                                                        .statusSet(facturaSave.getStatusSet())
                                                        .rg90Generado(facturaSave.getRg90Generado())
                                                        .contadorRg90(facturaSave.getContadorRg90())
                                                        .cliente(facturaSave.getCliente())
                                                        .tipoMoneda(facturaSave.getTipoMoneda())
                                                        .cotizacionCompra(facturaSave.getCotizacionCompra())
                                                        .cotizacionVenta(facturaSave.getCotizacionVenta())
                                                        .gravadaExentaMoneda(facturaSave.getGravadaExentaMoneda())
                                                        .gravadaCincoMoneda(facturaSave.getGravadaCincoMoneda())
                                                        .gravadaDiezMoneda(facturaSave.getGravadaDiezMoneda())
                                                        .totalGravadaMoneda(facturaSave.getTotalGravadaMoneda())
                                                        .exentaMoneda(facturaSave.getExentaMoneda())
                                                        .ivaCincoMoneda(facturaSave.getIvaCincoMoneda())
                                                        .ivaDiezMoneda(facturaSave.getIvaDiezMoneda())
                                                        .totalIvaMoneda(facturaSave.getTotalIvaMoneda())
                                                        .createdBy(facturaSave.getCreatedBy())
                                                        .createdAt(facturaSave.getCreatedAt())
                                                        .updatedAt(facturaSave.getUpdatedAt())
                                                        .updatedBy(facturaSave.getUpdatedBy())
                                                        .build())
                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("ERROR")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("factura/{id}")
        public ResponseEntity<?> update(@RequestBody FacturaDto facturaDto, @PathVariable Integer id) {

                Factura facturaUpdate = null;
                try {
                        if (facturaService.existsById(id)) {
                                facturaDto.setIdFactura(id);
                                facturaUpdate = facturaService.save(facturaDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("ACTUALIZADO")
                                                .objeto(FacturaDto.builder()
                                                                .idFactura(facturaUpdate.getIdFactura())
                                                                .empresa(facturaUpdate.getEmpresa())
                                                                .tipoFactura(facturaUpdate.getTipoFactura())
                                                                .timbradoFactura(facturaUpdate.getTimbradoFactura())
                                                                .cdcFactura(facturaUpdate.getCdcFactura())
                                                                .codigoControlFactura(
                                                                                facturaUpdate.getCodigoControlFactura())
                                                                .numeroFactura(facturaUpdate.getNumeroFactura())
                                                                .rucEmisorFactura(facturaUpdate.getRucEmisorFactura())
                                                                .razonSocialEmisorFactura(facturaUpdate
                                                                                .getRazonSocialEmisorFactura())
                                                                .rucReceptorFactura(
                                                                                facturaUpdate.getRucReceptorFactura())
                                                                .razonSocialReceptorFactura(facturaUpdate
                                                                                .getRazonSocialReceptorFactura())
                                                                .condicionVentaFactura(facturaUpdate
                                                                                .getCondicionVentaFactura())
                                                                .fechaInicioVigenciaFactura(facturaUpdate
                                                                                .getFechaInicioVigenciaFactura())
                                                                .fechaFinVigenciaFactura(facturaUpdate
                                                                                .getFechaFinVigenciaFactura())
                                                                .fechaEmisionFactura(
                                                                                facturaUpdate.getFechaEmisionFactura())
                                                                .montoTotalFacturaGs(
                                                                                facturaUpdate.getMontoTotalFacturaGs())
                                                                .montoTotalIvaFacturaGs(facturaUpdate
                                                                                .getMontoTotalIvaFacturaGs())
                                                                .montoCincoFacturaGs(
                                                                                facturaUpdate.getMontoCincoFacturaGs())
                                                                .montoDiezFacturaGs(
                                                                                facturaUpdate.getMontoDiezFacturaGs())
                                                                .exentaFacturaGs(facturaUpdate.getExentaFacturaGs())
                                                                .gravadaCincoGs(facturaUpdate.getGravadaCincoGs())
                                                                .gravadaDiezGs(facturaUpdate.getGravadaDiezGs())
                                                                .gravadaExentaGs(facturaUpdate.getGravadaExentaGs())
                                                                .statusFactura(facturaUpdate.getStatusFactura())
                                                                .monedaExtranjera(facturaUpdate.getMonedaExtranjera())
                                                                .tipoRegistro(facturaUpdate.getTipoRegistro())
                                                                .tipoComprobante(facturaUpdate.getTipoComprobante())
                                                                .detalleComprobante(
                                                                                facturaUpdate.getDetalleComprobante())
                                                                .tipoDocumento(facturaUpdate.getTipoDocumento())
                                                                .imputaIva(facturaUpdate.getImputaIva())
                                                                .imputaIre(facturaUpdate.getImputaIre())
                                                                .imputaIrpRsp(facturaUpdate.getImputaIrpRsp())
                                                                .timbradoComprobanteAsociado(facturaUpdate
                                                                                .getTimbradoComprobanteAsociado())
                                                                .statusSet(facturaUpdate.getStatusSet())
                                                                .rg90Generado(facturaUpdate.getRg90Generado())
                                                                .contadorRg90(facturaUpdate.getContadorRg90())
                                                                .cliente(facturaUpdate.getCliente())
                                                                .tipoMoneda(facturaUpdate.getTipoMoneda())
                                                                .cotizacionCompra(facturaUpdate.getCotizacionCompra())
                                                                .cotizacionVenta(facturaUpdate.getCotizacionVenta())
                                                                .gravadaExentaMoneda(
                                                                                facturaUpdate.getGravadaExentaMoneda())
                                                                .gravadaCincoMoneda(
                                                                                facturaUpdate.getGravadaCincoMoneda())
                                                                .gravadaDiezMoneda(facturaUpdate.getGravadaDiezMoneda())
                                                                .totalGravadaMoneda(
                                                                                facturaUpdate.getTotalGravadaMoneda())
                                                                .exentaMoneda(facturaUpdate.getExentaMoneda())
                                                                .ivaCincoMoneda(facturaUpdate.getIvaCincoMoneda())
                                                                .ivaDiezMoneda(facturaUpdate.getIvaDiezMoneda())
                                                                .totalIvaMoneda(facturaUpdate.getTotalIvaMoneda())
                                                                .createdBy(facturaUpdate.getCreatedBy())
                                                                .createdAt(facturaUpdate.getCreatedAt())
                                                                .updatedAt(facturaUpdate.getUpdatedAt())
                                                                .updatedBy(facturaUpdate.getUpdatedBy())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
                        } else {
                                return new ResponseEntity<>(
                                                MensajeResponse.builder()
                                                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                                                .objeto(null)
                                                                .build(),
                                                HttpStatus.NOT_FOUND);
                        }
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje(exDt.getMessage())
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("factura/autorizada/{id}&{status}")
        public ResponseEntity<?> updateStatusInvoice(@RequestBody FacturaDto facturaDto, @PathVariable Integer id,
                        @PathVariable String status) {

                Factura facturaUpdate = null;
                try {
                        if (facturaService.existsById(id)) {
                                facturaDto.setIdFactura(id);
                                facturaDto.setStatusSet(status);
                                facturaUpdate = facturaService.save(facturaDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("ACTUALIZADO")
                                                .objeto(FacturaDto.builder()
                                                                .idFactura(facturaUpdate.getIdFactura())
                                                                .empresa(facturaUpdate.getEmpresa())
                                                                .tipoFactura(facturaUpdate.getTipoFactura())
                                                                .timbradoFactura(facturaUpdate.getTimbradoFactura())
                                                                .cdcFactura(facturaUpdate.getCdcFactura())
                                                                .codigoControlFactura(
                                                                                facturaUpdate.getCodigoControlFactura())
                                                                .numeroFactura(facturaUpdate.getNumeroFactura())
                                                                .rucEmisorFactura(facturaUpdate.getRucEmisorFactura())
                                                                .razonSocialEmisorFactura(facturaUpdate
                                                                                .getRazonSocialEmisorFactura())
                                                                .rucReceptorFactura(
                                                                                facturaUpdate.getRucReceptorFactura())
                                                                .razonSocialReceptorFactura(facturaUpdate
                                                                                .getRazonSocialReceptorFactura())
                                                                .condicionVentaFactura(facturaUpdate
                                                                                .getCondicionVentaFactura())
                                                                .fechaInicioVigenciaFactura(facturaUpdate
                                                                                .getFechaInicioVigenciaFactura())
                                                                .fechaFinVigenciaFactura(facturaUpdate
                                                                                .getFechaFinVigenciaFactura())
                                                                .fechaEmisionFactura(
                                                                                facturaUpdate.getFechaEmisionFactura())
                                                                .montoTotalFacturaGs(
                                                                                facturaUpdate.getMontoTotalFacturaGs())
                                                                .montoTotalIvaFacturaGs(facturaUpdate
                                                                                .getMontoTotalIvaFacturaGs())
                                                                .montoCincoFacturaGs(
                                                                                facturaUpdate.getMontoCincoFacturaGs())
                                                                .montoDiezFacturaGs(
                                                                                facturaUpdate.getMontoDiezFacturaGs())
                                                                .exentaFacturaGs(facturaUpdate.getExentaFacturaGs())
                                                                .gravadaCincoGs(facturaUpdate.getGravadaCincoGs())
                                                                .gravadaDiezGs(facturaUpdate.getGravadaDiezGs())
                                                                .gravadaExentaGs(facturaUpdate.getGravadaExentaGs())
                                                                .statusFactura(facturaUpdate.getStatusFactura())
                                                                .monedaExtranjera(facturaUpdate.getMonedaExtranjera())
                                                                .tipoRegistro(facturaUpdate.getTipoRegistro())
                                                                .tipoComprobante(facturaUpdate.getTipoComprobante())
                                                                .tipoDocumento(facturaUpdate.getTipoDocumento())
                                                                .imputaIva(facturaUpdate.getImputaIva())
                                                                .imputaIre(facturaUpdate.getImputaIre())
                                                                .imputaIrpRsp(facturaUpdate.getImputaIrpRsp())
                                                                .timbradoComprobanteAsociado(facturaUpdate
                                                                                .getTimbradoComprobanteAsociado())
                                                                .statusSet(facturaUpdate.getStatusSet())
                                                                .rg90Generado(facturaUpdate.getRg90Generado())
                                                                .contadorRg90(facturaUpdate.getContadorRg90())
                                                                .cliente(facturaUpdate.getCliente())
                                                                .tipoMoneda(facturaUpdate.getTipoMoneda())
                                                                .cotizacionCompra(facturaUpdate.getCotizacionCompra())
                                                                .cotizacionVenta(facturaUpdate.getCotizacionVenta())
                                                                .gravadaExentaMoneda(
                                                                                facturaUpdate.getGravadaExentaMoneda())
                                                                .gravadaCincoMoneda(
                                                                                facturaUpdate.getGravadaCincoMoneda())
                                                                .gravadaDiezMoneda(facturaUpdate.getGravadaDiezMoneda())
                                                                .totalGravadaMoneda(
                                                                                facturaUpdate.getTotalGravadaMoneda())
                                                                .exentaMoneda(facturaUpdate.getExentaMoneda())
                                                                .ivaCincoMoneda(facturaUpdate.getIvaCincoMoneda())
                                                                .ivaDiezMoneda(facturaUpdate.getIvaDiezMoneda())
                                                                .totalIvaMoneda(facturaUpdate.getTotalIvaMoneda())
                                                                .createdBy(facturaUpdate.getCreatedBy())
                                                                .createdAt(facturaUpdate.getCreatedAt())
                                                                .updatedAt(facturaUpdate.getUpdatedAt())
                                                                .updatedBy(facturaUpdate.getUpdatedBy())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
                        } else {
                                return new ResponseEntity<>(
                                                MensajeResponse.builder()
                                                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                                                .objeto(null)
                                                                .build(),
                                                HttpStatus.NOT_FOUND);
                        }
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje(exDt.getMessage())
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @DeleteMapping("factura/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Factura facturaDelete = facturaService.findById(id);
                        if (facturaDelete == null) {
                                return new ResponseEntity<>(facturaDelete, HttpStatus.NOT_FOUND);
                        } else {
                                facturaService.delete(facturaDelete);
                                return new ResponseEntity<>(facturaDelete, HttpStatus.NO_CONTENT);
                        }

                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje(exDt.getMessage())
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

}
