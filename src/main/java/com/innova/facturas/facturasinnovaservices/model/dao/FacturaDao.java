package com.innova.facturas.facturasinnovaservices.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Factura;

@Repository
public interface FacturaDao extends JpaRepository<Factura, Integer> {

    // @Query("from Rgfactura r order by r.ruc, r.anhoPeriodo, r.mesPeriodo asc")
    // List<Factura> findAllOrderASC();

    // @Query("from Rgfactura r where r.ruc= :ruc order by r.anhoPeriodo,
    // r.mesPeriodo asc")
    // List<Factura> findAllByRuc(Integer ruc);

    // @Query("FROM Rgfactura r GROUP BY r.ruc, r.mesPeriodo, r.anhoPeriodo ORDER BY
    // r.ruc, r.anhoPeriodo, r.mesPeriodo ASC")
    // List<Factura> listRg90();

    @Query("FROM Factura f GROUP BY f.rucReceptorFactura, MONTH(f.fechaEmisionFactura), YEAR(f.fechaEmisionFactura) ORDER BY YEAR(f.fechaEmisionFactura) DESC,  f.rucReceptorFactura DESC, MONTH(f.fechaEmisionFactura) DESC")
    List<Factura> listPeriodosClientes();

    @Query("FROM Factura f WHERE f.timbradoFactura= :timbrado AND f.tipoComprobante= :comprobante AND f.numeroFactura= :nro GROUP BY f.timbradoFactura")
    Optional<Factura> searchInvoice(String timbrado, Integer comprobante, String nro);

    @Query("FROM Factura f WHERE f.cliente.ruc= :ruc AND f.statusFactura = 'PROCESADA' AND YEAR(f.fechaEmisionFactura)= :anho AND MONTH(f.fechaEmisionFactura)= :mes")
    List<Factura> invoiceOfSelectedPeriod(String ruc, Integer anho, Integer mes);

}
