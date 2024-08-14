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
import com.innova.facturas.facturasinnovaservices.model.dto.UserDto;
import com.innova.facturas.facturasinnovaservices.model.entity.User;
import com.innova.facturas.facturasinnovaservices.services.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("users")
        public ResponseEntity<?> showAll() {

                List<User> users = userService.getAllUsers();

                if (users == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(users)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(users)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("user/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                User user = userService.findById(id);

                if (user == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(user)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(user)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("user")
        public ResponseEntity<?> create(@RequestBody UserDto userDto) {
                User userSave = null;

                try {
                        userSave = userService.save(userDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(UserDto.builder()
                                                                        .idUser(userSave.getIdUser())
                                                                        .idEmpresa(userSave.getIdEmpresa())
                                                                        .rol(userSave.getRol())
                                                                        .username(userSave
                                                                                        .getUsername())
                                                                        .password(userSave
                                                                                        .getPassword())
                                                                        .lastLogin(userSave
                                                                                        .getLastLogin())
                                                                        .createdAt(userSave
                                                                                        .getCreatedAt())
                                                                        .updatedAt(userSave
                                                                                        .getUpdatedAt())
                                                                        .persona(userSave
                                                                                        .getPersona())
                                                                        .statusUser(userSave
                                                                                        .getStatusUser())
                                                                        .createdBy(userSave
                                                                                        .getCreatedBy())
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

        @PutMapping("user/{id}")
        public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Integer id) {

                User userUpdate = null;
                try {
                        if (userService.existsById(id)) {
                                userDto.setIdUser(id);
                                userUpdate = userService.save(userDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(UserDto.builder()
                                                                .idUser(userUpdate.getIdUser())
                                                                .idEmpresa(userUpdate.getIdEmpresa())
                                                                .rol(userUpdate.getRol())
                                                                .username(userUpdate.getUsername())
                                                                .password(userUpdate.getPassword())
                                                                .lastLogin(userUpdate.getLastLogin())
                                                                .createdAt(userUpdate.getCreatedAt())
                                                                .updatedAt(userUpdate.getUpdatedAt())
                                                                .persona(userUpdate.getPersona())
                                                                .statusUser(userUpdate.getStatusUser())
                                                                .createdBy(userUpdate.getCreatedBy())
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

        @DeleteMapping("user/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        User userDelete = userService.findById(id);
                        if (userDelete == null) {
                                return new ResponseEntity<>(userDelete, HttpStatus.NOT_FOUND);
                        } else {
                                userService.delete(userDelete);
                                return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
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
