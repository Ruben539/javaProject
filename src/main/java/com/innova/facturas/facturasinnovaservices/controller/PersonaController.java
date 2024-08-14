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
import com.innova.facturas.facturasinnovaservices.model.dto.PersonaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Persona;
import com.innova.facturas.facturasinnovaservices.services.PersonaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PersonaController {

        @Autowired
        private PersonaService personaService;

        @GetMapping("personas")
        public ResponseEntity<?> showAll() {

                List<Persona> personas = personaService.getAllPersonas();

                if (personas == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(personas)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(personas)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("persona/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Persona persona = personaService.findById(id);

                if (persona == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(persona)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(persona)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("persona")
        public ResponseEntity<?> create(@RequestBody PersonaDto personaDto) {
                Persona personaSave = null;

                try {
                        personaSave = personaService.save(personaDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(
                                                                        PersonaDto.builder()
                                                                                        .idPersona(personaSave
                                                                                                        .getIdPersona())
                                                                                        .nombrePersona(personaSave
                                                                                                        .getNombrePersona())
                                                                                        .apellidoPersona(personaSave
                                                                                                        .getApellidoPersona())
                                                                                        .telefonoPersona(personaSave
                                                                                                        .getTelefonoPersona())
                                                                                        .ciPersona(personaSave
                                                                                                        .getCiPersona())
                                                                                        .statusPersona(personaSave
                                                                                                        .getStatusPersona())
                                                                                        .createdAt(personaSave
                                                                                                        .getCreatedAt())
                                                                                        .createdBy(personaSave
                                                                                                        .getCreatedBy())
                                                                                        .updatedAt(personaSave
                                                                                                        .getUpdatedAt())
                                                                                        .updatedBy(personaSave
                                                                                                        .getUpdatedBy())
                                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear Persona")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("persona/{id}")
        public ResponseEntity<?> update(@RequestBody PersonaDto personaDto, @PathVariable Integer id) {

                Persona personaUpdate = null;
                try {
                        if (personaService.existsById(id)) {
                                personaDto.setIdPersona(id);
                                personaUpdate = personaService.save(personaDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(PersonaDto.builder()
                                                                .idPersona(personaUpdate.getIdPersona())
                                                                .nombrePersona(personaUpdate.getNombrePersona())
                                                                .apellidoPersona(personaUpdate.getApellidoPersona())
                                                                .telefonoPersona(personaUpdate.getTelefonoPersona())
                                                                .ciPersona(personaUpdate.getCiPersona())
                                                                .statusPersona(personaUpdate.getStatusPersona())
                                                                .createdAt(personaUpdate.getCreatedAt())
                                                                .createdBy(personaUpdate.getCreatedBy())
                                                                .updatedAt(personaUpdate.getUpdatedAt())
                                                                .updatedBy(personaUpdate.getUpdatedBy())
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

        @DeleteMapping("persona/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Persona personaDelete = personaService.findById(id);
                        if (personaDelete == null) {
                                return new ResponseEntity<>(personaDelete, HttpStatus.NOT_FOUND);
                        } else {
                                personaService.delete(personaDelete);
                                return new ResponseEntity<>(personaDelete, HttpStatus.NO_CONTENT);
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
