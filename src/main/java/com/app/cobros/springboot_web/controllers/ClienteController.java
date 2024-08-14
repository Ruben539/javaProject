package com.app.cobros.springboot_web.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cobros.springboot_web.exception.MensajeResponse;
import com.app.cobros.springboot_web.model.dto.ClienteDto;
import com.app.cobros.springboot_web.model.entity.Clientes;
import com.app.cobros.springboot_web.services.ClienteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ClienteController {
        @Autowired
        private ClienteService clienteService;

        @GetMapping("clientes")
        public ResponseEntity<?> showAll() {

                List<Clientes> clientes = clienteService.getAllClientes();

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

        @GetMapping("clientes/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {
                
                Clientes clientes = clienteService.findById(id);
                
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
                                                .mensaje("Registro encontrado:")
                                                .objeto(clientes)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("clientes")
        public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
                Clientes clienteSave = null;

                try {
                        clienteSave = clienteService.save(clienteDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(clienteDto.builder()
                                                                        .id(clienteSave.getId())
                                                                        .cedula(clienteSave
                                                                                        .getCedula())
                                                                        .nombre(clienteSave
                                                                                        .getNombre())
                                                                        .correo(clienteSave
                                                                                        .getCorreo())
                                                                        .estadoId(clienteDto
                                                                                        .getEstadoId())
                                                                        .createdAt(clienteSave
                                                                                        .getCreatedAt())
                                                                        .updatedAt(clienteSave
                                                                                        .getUpdatedAt())
                                                                        .deletedAt(clienteSave
                                                                                        .getDeletedAt())
                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear usuario")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("clientes/{id}")
        public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {

                Clientes clienteUpdate = null;
                try {
                        if (clienteService.existsById(id)) {
                                clienteDto.setId(id);
                                clienteUpdate = clienteService.save(clienteDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(clienteDto.builder()
                                                                .id(clienteUpdate.getId())
                                                                .cedula(clienteUpdate.getCedula())
                                                                .nombre(clienteUpdate.getNombre())
                                                                .correo(clienteUpdate.getCorreo())
                                                                .estadoId(clienteUpdate.getEstadoId())
                                                                .createdAt(clienteUpdate.getCreatedAt())
                                                                .updatedAt(clienteUpdate.getUpdatedAt())
                                                                .deletedAt(clienteUpdate.getDeletedAt())
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

        @DeleteMapping("clientes/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Clientes clienteDelete = clienteService.findById(id);
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
