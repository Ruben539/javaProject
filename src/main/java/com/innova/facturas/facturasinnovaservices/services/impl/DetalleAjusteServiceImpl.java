package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.DetalleAjusteDao;
import com.innova.facturas.facturasinnovaservices.model.dto.DetalleAjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;
import com.innova.facturas.facturasinnovaservices.services.DetalleAjusteService;

@Service
public class DetalleAjusteServiceImpl implements DetalleAjusteService {

    @Autowired
    private DetalleAjusteDao detalleAjusteDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<DetalleAjuste> getDetailSetting(Integer id) {
        return (List) detalleAjusteDao.listDetailSettingById(id);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<DetalleAjuste> getDetailBySettingGroup(String ajuste) {
        return (List) detalleAjusteDao.listDetailBySettingGroup(ajuste);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<DetalleAjuste> getExchangeByDate(String fecha, String moneda) {
        return (List) detalleAjusteDao.listExchangeByDate(fecha, moneda);
    }

    @Transactional
    @Override
    public DetalleAjuste save(DetalleAjusteDto detalleAjusteDto) {
        DetalleAjuste detalleAjuste = DetalleAjuste.builder()
                .idDetalleAjuste(detalleAjusteDto.getIdDetalleAjuste())
                .ajuste(detalleAjusteDto.getAjuste())
                .etiqueta(detalleAjusteDto.getEtiqueta())
                .acronimo(detalleAjusteDto.getAcronimo())
                .valorEntrada(detalleAjusteDto.getValorEntrada())
                .valorSalida(detalleAjusteDto.getValorSalida())
                .status(detalleAjusteDto.getStatus())
                .createdBy(detalleAjusteDto.getCreatedBy())
                .createdAt(detalleAjusteDto.getCreatedAt())
                .updatedBy(detalleAjusteDto.getUpdatedBy())
                .updatedAt(detalleAjusteDto.getUpdatedAt())
                .build();

        return detalleAjusteDao.save(detalleAjuste);
    }

    @Transactional(readOnly = true)
    @Override
    public DetalleAjuste findById(Integer id) {
        return detalleAjusteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(DetalleAjuste detalleAjuste) {
        detalleAjusteDao.delete(detalleAjuste);
    }

    @Override
    public boolean existsById(Integer id) {
        return detalleAjusteDao.existsById(id);
    }

}
