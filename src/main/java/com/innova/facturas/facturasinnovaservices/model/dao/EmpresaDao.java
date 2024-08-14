package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

@Repository
public interface EmpresaDao extends CrudRepository<Empresa, Integer> {

}
