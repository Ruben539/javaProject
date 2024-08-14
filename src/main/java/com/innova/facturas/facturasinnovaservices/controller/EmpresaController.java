package com.innova.facturas.facturasinnovaservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.facturas.facturasinnovaservices.exception.MensajeResponse;
import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;
import com.innova.facturas.facturasinnovaservices.services.EmpresaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("empresa/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {

        Empresa empresa = empresaService.findById(id);

        if (empresa == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .objeto(empresa)
                            .build(),
                    HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registro encontrado:")
                        .objeto(empresa)
                        .build(),
                HttpStatus.OK);

    }

}
