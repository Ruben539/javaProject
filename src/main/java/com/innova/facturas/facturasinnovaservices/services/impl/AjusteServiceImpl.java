package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.AjusteDao;
import com.innova.facturas.facturasinnovaservices.model.dto.AjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;
import com.innova.facturas.facturasinnovaservices.services.AjusteService;

@Service
public class AjusteServiceImpl implements AjusteService {

    @Autowired
    private AjusteDao ajusteDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Ajuste> getAllAjustes() {
        return (List) ajusteDao.findAll();
    }

    @Transactional
    @Override
    public Ajuste save(AjusteDto ajusteDto) {
        Ajuste ajuste = Ajuste.builder()
                .idAjuste(ajusteDto.getIdAjuste())
                .empresa(ajusteDto.getEmpresa())
                .nombreAjuste(ajusteDto.getNombreAjuste())
                .acronimo(ajusteDto.getAcronimo())
                .descripcion(ajusteDto.getDescripcion())
                .status(ajusteDto.getStatus())
                .createdBy(ajusteDto.getCreatedBy())
                .createdAt(ajusteDto.getCreatedAt())
                .updatedBy(ajusteDto.getUpdatedBy())
                .updatedAt(ajusteDto.getUpdatedAt())
                .build();

        return ajusteDao.save(ajuste);
    }

    @Transactional(readOnly = true)
    @Override
    public Ajuste findById(Integer id) {
        return ajusteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Ajuste ajuste) {
        ajusteDao.delete(ajuste);
    }

    @Override
    public boolean existsById(Integer id) {
        return ajusteDao.existsById(id);
    }

}
