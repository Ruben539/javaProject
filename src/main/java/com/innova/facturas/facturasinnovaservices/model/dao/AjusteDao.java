package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;

@Repository
public interface AjusteDao extends JpaRepository<Ajuste, Integer> {

}
