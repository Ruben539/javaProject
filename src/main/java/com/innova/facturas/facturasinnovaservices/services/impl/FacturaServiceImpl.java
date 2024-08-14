package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.FacturaDao;
import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;
import com.innova.facturas.facturasinnovaservices.services.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Factura> getAllFacturas() {
        return (List) facturaDao.findAll();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Factura> listPeriodosClientes() {
        return (List) facturaDao.listPeriodosClientes();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Factura> invoiceOfSelectedPeriod(String ruc, String anho, String mes) {
        return (List) facturaDao.invoiceOfSelectedPeriod(ruc, Integer.parseInt(anho), Integer.parseInt(mes));
    }

    @Transactional
    @Override
    public Factura save(FacturaDto facturaDto) {

        Factura factura = Factura.builder()
                .idFactura(facturaDto.getIdFactura())
                .empresa(facturaDto.getEmpresa())
                .tipoFactura(facturaDto.getTipoFactura())
                .timbradoFactura(facturaDto.getTimbradoFactura())
                .cdcFactura(facturaDto.getCdcFactura())
                .codigoControlFactura(facturaDto.getCodigoControlFactura())
                .numeroFactura(facturaDto.getNumeroFactura())
                .rucEmisorFactura(facturaDto.getRucEmisorFactura())
                .razonSocialEmisorFactura(facturaDto.getRazonSocialEmisorFactura())
                .rucReceptorFactura(facturaDto.getRucReceptorFactura())
                .razonSocialReceptorFactura(facturaDto.getRazonSocialReceptorFactura())
                .condicionVentaFactura(facturaDto.getCondicionVentaFactura())
                .fechaInicioVigenciaFactura(facturaDto.getFechaInicioVigenciaFactura())
                .fechaFinVigenciaFactura(facturaDto.getFechaFinVigenciaFactura())
                .fechaEmisionFactura(facturaDto.getFechaEmisionFactura())
                .montoTotalFacturaGs(facturaDto.getMontoTotalFacturaGs())
                .montoTotalIvaFacturaGs(facturaDto.getMontoTotalIvaFacturaGs())
                .montoCincoFacturaGs(facturaDto.getMontoCincoFacturaGs())
                .montoDiezFacturaGs(facturaDto.getMontoDiezFacturaGs())
                .exentaFacturaGs(facturaDto.getExentaFacturaGs())
                .gravadaCincoGs(facturaDto.getGravadaCincoGs())
                .gravadaDiezGs(facturaDto.getGravadaDiezGs())
                .gravadaExentaGs(facturaDto.getGravadaExentaGs())
                .statusFactura(facturaDto.getStatusFactura())
                .monedaExtranjera(facturaDto.getMonedaExtranjera())
                .tipoRegistro(facturaDto.getTipoRegistro())
                .tipoComprobante(facturaDto.getTipoComprobante())
                .detalleComprobante(facturaDto.getDetalleComprobante())
                .tipoDocumento(facturaDto.getTipoDocumento())
                .imputaIva(facturaDto.getImputaIva())
                .imputaIre(facturaDto.getImputaIre())
                .imputaIrpRsp(facturaDto.getImputaIrpRsp())
                .timbradoComprobanteAsociado(
                        facturaDto.getTimbradoComprobanteAsociado())
                .statusSet(facturaDto.getStatusSet())
                .rg90Generado(facturaDto
                        .getRg90Generado())
                .contadorRg90(facturaDto
                        .getContadorRg90())
                .cliente(facturaDto.getCliente())
                .tipoMoneda(facturaDto.getTipoMoneda())
                .cotizacionCompra(facturaDto.getCotizacionCompra())
                .cotizacionVenta(facturaDto.getCotizacionVenta())
                .gravadaExentaMoneda(facturaDto.getGravadaExentaMoneda())
                .gravadaCincoMoneda(facturaDto.getGravadaCincoMoneda())
                .gravadaDiezMoneda(facturaDto.getGravadaDiezMoneda())
                .totalGravadaMoneda(facturaDto.getTotalGravadaMoneda())
                .exentaMoneda(facturaDto.getExentaMoneda())
                .ivaCincoMoneda(facturaDto.getIvaCincoMoneda())
                .ivaDiezMoneda(facturaDto.getIvaDiezMoneda())
                .totalIvaMoneda(facturaDto.getTotalIvaMoneda())
                .createdBy(facturaDto.getCreatedBy())
                .createdAt(facturaDto.getCreatedAt())
                .updatedAt(facturaDto.getUpdatedAt())
                .updatedBy(facturaDto.getUpdatedBy())
                .build();
        return facturaDao.save(factura);
    }

    @Transactional(readOnly = true)
    @Override
    public Factura findById(Integer id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Factura searchInvoice(String timbrado, Integer comprobante, String nro) {
        return facturaDao.searchInvoice(timbrado, comprobante, nro).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public boolean existsById(Integer id) {
        return facturaDao.existsById(id);
    }

}
