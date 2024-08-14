package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.DetalleAjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;

public interface DetalleAjusteService {

    DetalleAjuste save(DetalleAjusteDto detalleAjusteDto);

    DetalleAjuste findById(Integer id);

    void delete(DetalleAjuste detalleAjuste);

    List<DetalleAjuste> getDetailSetting(Integer idAjuste);

    List<DetalleAjuste> getDetailBySettingGroup(String ajuste);

    List<DetalleAjuste> getExchangeByDate(String fecha, String moneda);

    boolean existsById(Integer id);
}
