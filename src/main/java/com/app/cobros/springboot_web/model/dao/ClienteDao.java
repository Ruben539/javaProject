package com.app.cobros.springboot_web.model.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.cobros.springboot_web.model.entity.Clientes;

@Repository
public interface ClienteDao extends CrudRepository<Clientes, Integer> {


    
}
