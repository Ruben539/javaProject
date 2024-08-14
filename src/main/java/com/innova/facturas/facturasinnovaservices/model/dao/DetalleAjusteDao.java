package com.innova.facturas.facturasinnovaservices.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;

@Repository
public interface DetalleAjusteDao extends JpaRepository<DetalleAjuste, Integer> {

    @Query("FROM DetalleAjuste d WHERE d.ajuste.idAjuste= :idAjuste")
    List<DetalleAjuste> listDetailSettingById(Integer idAjuste);

    @Query("FROM DetalleAjuste d WHERE d.ajuste.nombreAjuste= :ajuste GROUP BY d.acronimo")
    List<DetalleAjuste> listDetailBySettingGroup(String ajuste);

    @Query(value = "SELECT * FROM detalle_ajuste d WHERE d.created_at= ? AND d.acronimo = ?", nativeQuery = true)
    List<DetalleAjuste> listExchangeByDate(String fecha, String moneda);

}
