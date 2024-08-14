package com.app.cobros.springboot_web.services;

import java.util.List;

import com.app.cobros.springboot_web.model.dto.ClienteDto;
import com.app.cobros.springboot_web.model.entity.Clientes;

public interface ClienteService {

    Clientes save(ClienteDto clienteDto);

    Clientes findById(Integer id);

    void delete(Clientes cliente);

    List<Clientes> getAllClientes();

    boolean existsById(Integer id);
}
