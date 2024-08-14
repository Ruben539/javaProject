package com.app.cobros.springboot_web.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cobros.springboot_web.model.dao.ClienteDao;
import com.app.cobros.springboot_web.model.dto.ClienteDto;
import com.app.cobros.springboot_web.model.entity.Clientes;
import com.app.cobros.springboot_web.services.ClienteService;

import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServicesImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Clientes> getAllClientes() {
        return (List) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Clientes save(ClienteDto clienteDto) {

        Clientes cliente = Clientes.builder()
                .id(clienteDto.getId())
                .cedula(clienteDto.getCedula())
                .nombre(clienteDto.getNombre())
                .correo(clienteDto.getCorreo())
                .estadoId(clienteDto.getEstadoId())
                .createdAt(clienteDto.getCreatedAt())
                .updatedAt(clienteDto.getUpdatedAt())
                .deletedAt(clienteDto.getDeletedAt())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Clientes findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Clientes cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existsById(Long id) {
        return clienteDao.existsById(id);
    }
}
