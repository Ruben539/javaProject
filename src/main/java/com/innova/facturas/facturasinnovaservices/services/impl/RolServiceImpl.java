package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.facturas.facturasinnovaservices.model.dao.RolDao;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;
import com.innova.facturas.facturasinnovaservices.services.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Rol> getAllRoles() {
        return (List) rolDao.findAll();
    }

}
