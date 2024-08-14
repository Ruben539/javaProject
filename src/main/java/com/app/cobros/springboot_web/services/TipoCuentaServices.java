package com.app.cobros.springboot_web.services;

import java.util.List;

import com.app.cobros.springboot_web.model.dto.TipoCuentasDto;
import com.app.cobros.springboot_web.model.entity.TipoCuentas;

public interface TipoCuentaServices {
    TipoCuentas save(TipoCuentasDto tipoCuentaDto);

    TipoCuentas findById(Long id);

    void delete(TipoCuentas tipocuenta);

    List<TipoCuentas> getAllTipoCuentas();

    boolean existsById(Long id);
}
