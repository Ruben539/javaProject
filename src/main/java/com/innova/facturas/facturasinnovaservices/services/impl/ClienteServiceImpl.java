package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.ClienteDao;
import com.innova.facturas.facturasinnovaservices.model.dto.ClienteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;
import com.innova.facturas.facturasinnovaservices.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Cliente> getAllClientes() {
        return (List) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .empresa(clienteDto.getEmpresa())
                .ruc(clienteDto.getRuc())
                .nombreCliente(clienteDto.getNombreCliente())
                .rucCliente(clienteDto.getRucCliente())
                .dvRucCliente(clienteDto.getDvRucCliente())
                .direccionCliente(clienteDto.getDireccionCliente())
                .telefonoCliente(clienteDto.getTelefonoCliente())
                .correoCliente(clienteDto.getCorreoCliente())
                .estadoCliente(clienteDto.getEstadoCliente())
                .fechaCierreCliente(clienteDto.getFechaCierreCliente())
                .createdAt(clienteDto.getCreatedAt())
                .createdBy(clienteDto.getCreatedBy())
                .updatedAt(clienteDto.getUpdatedAt())
                .updatedBy(clienteDto.getUpdatedBy()).build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }

}
