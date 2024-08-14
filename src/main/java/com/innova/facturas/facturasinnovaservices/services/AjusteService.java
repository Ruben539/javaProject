package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.AjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;

public interface AjusteService {

    Ajuste save(AjusteDto ajusteDto);

    Ajuste findById(Integer id);

    void delete(Ajuste ajuste);

    List<Ajuste> getAllAjustes();

    boolean existsById(Integer id);

}
