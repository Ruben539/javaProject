package com.app.cobros.springboot_web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cobros.springboot_web.model.dao.TipoCuentasDao;
import com.app.cobros.springboot_web.model.dto.TipoCuentasDto;
import com.app.cobros.springboot_web.model.entity.TipoCuentas;
import com.app.cobros.springboot_web.services.TipoCuentaServices;


@Service
public class TipoCuentaServiceImpl implements TipoCuentaServices {

     @Autowired
    private TipoCuentasDao tipoCuentasDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<TipoCuentas> getAllTipoCuentas() {
        return (List) tipoCuentasDao.findAll();
    }

     @Transactional
    @Override
    public TipoCuentas save(TipoCuentasDto tipoCuentasDto) {

        TipoCuentas tipoCuentas = TipoCuentas.builder()
                .id(tipoCuentasDto.getId())
                .descripcion(tipoCuentasDto.getDescripcion())
                .createdAt(tipoCuentasDto.getCreatedAt())
                .updatedAt(tipoCuentasDto.getUpdatedAt())
                .deletedAt(tipoCuentasDto.getDeletedAt())
                .build();
                return tipoCuentasDao.save(tipoCuentas);
    }


    @Transactional(readOnly = true)
    @Override
    public TipoCuentas findById(Long id) {
        return tipoCuentasDao.findById(id).orElse(null);
    }


    @Transactional
    @Override
    public void delete(TipoCuentas tipoCuentas) {
        tipoCuentasDao.delete(tipoCuentas);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoCuentasDao.existsById(id);
    }
}
