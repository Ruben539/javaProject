package com.innova.facturas.facturasinnovaservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.facturas.facturasinnovaservices.exception.MensajeResponse;
import com.innova.facturas.facturasinnovaservices.model.dto.ClienteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;
import com.innova.facturas.facturasinnovaservices.services.ClienteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ClienteController {

        @Autowired
        private ClienteService clienteService;

        @GetMapping("clientes")
        public ResponseEntity<?> showAll() {

                List<Cliente> clientes = clienteService.getAllClientes();

                if (clientes == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(clientes)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(clientes)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("cliente/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Cliente cliente = clienteService.findById(id);

                if (cliente == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(cliente)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(cliente)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("cliente")
        public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
                Cliente clienteSave = null;

                try {
                        clienteSave = clienteService.save(clienteDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("CREADO")
                                                        .objeto(ClienteDto.builder()
                                                                        .idCliente(clienteSave.getIdCliente())
                                                                        .empresa(clienteSave.getEmpresa())
                                                                        .nombreCliente(clienteSave.getNombreCliente())
                                                                        .ruc(clienteSave.getRuc())
                                                                        .rucCliente(clienteSave.getRucCliente())
                                                                        .dvRucCliente(clienteSave.getDvRucCliente())
                                                                        .direccionCliente(clienteSave
                                                                                        .getDireccionCliente())
                                                                        .telefonoCliente(clienteSave
                                                                                        .getTelefonoCliente())
                                                                        .correoCliente(clienteSave.getCorreoCliente())
                                                                        .estadoCliente(clienteSave.getEstadoCliente())
                                                                        .fechaCierreCliente(clienteSave
                                                                                        .getFechaCierreCliente())
                                                                        .createdAt(clienteSave.getCreatedAt())
                                                                        .createdBy(clienteSave.getCreatedBy())
                                                                        .updatedAt(clienteSave.getUpdatedAt())
                                                                        .updatedBy(clienteSave.getUpdatedBy())
                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear cliente")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("cliente/{id}")
        public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {

                Cliente clienteUpdate = null;
                try {
                        if (clienteService.existsById(id)) {
                                clienteDto.setIdCliente(id);
                                clienteUpdate = clienteService.save(clienteDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("ACTUALIZADO")
                                                .objeto(ClienteDto.builder()
                                                                .idCliente(clienteUpdate.getIdCliente())
                                                                .empresa(clienteUpdate.getEmpresa())
                                                                .ruc(clienteUpdate.getRuc())
                                                                .nombreCliente(clienteUpdate.getNombreCliente())
                                                                .rucCliente(clienteUpdate.getRucCliente())
                                                                .dvRucCliente(clienteUpdate.getDvRucCliente())
                                                                .direccionCliente(clienteUpdate.getDireccionCliente())
                                                                .telefonoCliente(clienteUpdate.getTelefonoCliente())
                                                                .correoCliente(clienteUpdate.getCorreoCliente())
                                                                .estadoCliente(clienteUpdate.getEstadoCliente())
                                                                .fechaCierreCliente(
                                                                                clienteUpdate.getFechaCierreCliente())
                                                                .createdAt(clienteUpdate.getCreatedAt())
                                                                .createdBy(clienteUpdate.getCreatedBy())
                                                                .updatedAt(clienteUpdate.getUpdatedAt())
                                                                .updatedBy(clienteUpdate.getUpdatedBy())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
                        } else {
                                return new ResponseEntity<>(
                                                MensajeResponse.builder()
                                                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                                                .objeto(null)
                                                                .build(),
                                                HttpStatus.NOT_FOUND);
                        }
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje(exDt.getMessage())
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @DeleteMapping("cliente/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Cliente clienteDelete = clienteService.findById(id);
                        if (clienteDelete == null) {
                                return new ResponseEntity<>(clienteDelete, HttpStatus.NOT_FOUND);
                        } else {
                                clienteService.delete(clienteDelete);
                                return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
                        }

                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje(exDt.getMessage())
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

}
