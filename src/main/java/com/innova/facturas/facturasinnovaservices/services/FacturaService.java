package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;

public interface FacturaService {

    Factura save(FacturaDto facturaDto);

    Factura findById(Integer id);

    void delete(Factura factura);

    List<Factura> getAllFacturas();

    boolean existsById(Integer id);

    List<Factura> listPeriodosClientes();

    Factura searchInvoice(String timbrado, Integer comprobante, String nro);

    List<Factura> invoiceOfSelectedPeriod(String ruc, String anho, String mes);

}
