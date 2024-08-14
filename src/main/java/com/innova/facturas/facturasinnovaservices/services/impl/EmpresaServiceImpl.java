package com.innova.facturas.facturasinnovaservices.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.EmpresaDao;
import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;
import com.innova.facturas.facturasinnovaservices.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaDao empresaDao;

    @Transactional(readOnly = true)
    @Override
    public Empresa findById(Integer id) {
        return empresaDao.findById(id).orElse(null);
    }

}
