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
import com.app.cobros.springboot_web.model.dto.TipoCuentasDto;
import com.app.cobros.springboot_web.model.entity.TipoCuentas;
import com.app.cobros.springboot_web.services.TipoCuentaServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class TipoCuentasController {

      @Autowired
        private TipoCuentaServices tipoCuentaServices;

        @GetMapping("tipo_cuentas")
            public ResponseEntity<?> showAll() {

                List<TipoCuentas> tipoCuentas = tipoCuentaServices.getAllTipoCuentas();


                if (tipoCuentas == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(tipoCuentas)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(tipoCuentas)
                                                .build(),
                                HttpStatus.OK);
        }


        @PostMapping("tipo_cuentas")
        public ResponseEntity<?> create(@RequestBody TipoCuentasDto tipoCuentaDto) {
                TipoCuentas tipocuentasave = null;

                try {
                    tipocuentasave = tipoCuentaServices.save(tipoCuentaDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Registro creado")
                                                        .objeto(tipoCuentaDto.builder()
                                                                        .id(tipocuentasave.getId())
                                                                      
                                                                        .descripcion(tipocuentasave
                                                                                        .getDescripcion())
                                                                        .createdAt(tipocuentasave
                                                                                        .getCreatedAt())
                                                                        .updatedAt(tipocuentasave
                                                                                        .getUpdatedAt())
                                                                        .deletedAt(tipocuentasave
                                                                                        .getDeletedAt())
                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear registro")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }


        @GetMapping("tipo_cuentas/{id}")
        public ResponseEntity<?> showById(@PathVariable Long id) {
                
                TipoCuentas tipoCuentas = tipoCuentaServices.findById(id);
                
                if (tipoCuentas == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(tipoCuentas)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(tipoCuentas)
                                                .build(),
                                HttpStatus.OK);

        }


        

        @PutMapping("tipo_cuentas/{id}")
        public ResponseEntity<?> update(@RequestBody TipoCuentasDto tipoCuentasDto, @PathVariable Long id) {

                TipoCuentas tipocuentaupdate = null;
                try {
                        if (tipoCuentaServices.existsById(id)) {
                            tipoCuentasDto.setId(id);
                            tipocuentaupdate = tipoCuentaServices.save(tipoCuentasDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(tipoCuentasDto.builder()
                                                                .id(tipoCuentasDto.getId())
                                                                .descripcion(tipocuentaupdate.getDescripcion())
                                                                .createdAt(tipocuentaupdate.getCreatedAt())
                                                                .updatedAt(tipocuentaupdate.getUpdatedAt())
                                                                .deletedAt(tipocuentaupdate.getDeletedAt())
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


        @DeleteMapping("tipo_cuentas/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

                try {
                        TipoCuentas tipocuentadelete = tipoCuentaServices.findById(id);
                        if (tipocuentadelete == null) {
                                return new ResponseEntity<>(tipocuentadelete, HttpStatus.NOT_FOUND);
                        } else {
                                tipoCuentaServices.delete(tipocuentadelete);
                                return new ResponseEntity<>(tipocuentadelete, HttpStatus.NO_CONTENT);
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
