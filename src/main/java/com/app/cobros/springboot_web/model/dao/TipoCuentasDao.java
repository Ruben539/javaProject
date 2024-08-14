package com.app.cobros.springboot_web.model.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.app.cobros.springboot_web.model.entity.TipoCuentas;

@Repository
public interface  TipoCuentasDao extends CrudRepository<TipoCuentas, Long> {

}
