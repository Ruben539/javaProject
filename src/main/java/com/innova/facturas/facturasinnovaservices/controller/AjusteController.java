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
import com.innova.facturas.facturasinnovaservices.model.dto.AjusteDto;
import com.innova.facturas.facturasinnovaservices.model.dto.DetalleAjusteDto;
import com.innova.facturas.facturasinnovaservices.model.dto.ListaDetalleAjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;
import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;
import com.innova.facturas.facturasinnovaservices.services.AjusteService;
import com.innova.facturas.facturasinnovaservices.services.DetalleAjusteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AjusteController {

        @Autowired
        private AjusteService ajusteService;

        @Autowired
        private DetalleAjusteService detalleAjusteService;

        @GetMapping("settings")
        public ResponseEntity<?> showAll() {
                List<Ajuste> ajustes = ajusteService.getAllAjustes();

                if (ajustes == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(ajustes)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(ajustes)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("setting/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Ajuste ajuste = ajusteService.findById(id);

                if (ajuste == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(ajuste)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(ajuste)
                                                .build(),
                                HttpStatus.OK);

        }

        // @GetMapping("allsettingsdetails")
        // public ResponseEntity<?> getAllDetailsSettings() {
        // List<Ajuste> ajustes = ajusteService.getAllAjustes();

        // if (ajustes == null) {
        // return new ResponseEntity<>(
        // MensajeResponse.builder()
        // .mensaje("No hay registros")
        // .objeto(ajustes)
        // .build(),
        // HttpStatus.NOT_FOUND);
        // }
        // List<ListaDetalleAjusteDto> detalleAjuste;
        // for (Ajuste ajuste : ajustes) {
        // ListaDetalleAjusteDto temp = new ListaDetalleAjusteDto(0, null, null, null,
        // null,
        // null, 0,
        // null, 0, null, null);

        // temp.setIdAjuste(ajuste.getIdAjuste());
        // temp.setEmpresa(ajuste.getEmpresa());
        // temp.setNombreAjuste(ajuste.getNombreAjuste());
        // temp.setAcronimo(ajuste.getAcronimo());
        // temp.setDescripcion(ajuste.getDescripcion());
        // temp.setStatus(ajuste.getStatus());
        // temp.setCreatedAt(ajuste.getCreatedAt());
        // temp.setCreatedBy(ajuste.getCreatedBy());
        // temp.setUpdatedAt(ajuste.getUpdatedAt());
        // temp.setUpdatedBy(ajuste.getUpdatedBy());

        // List<DetalleAjusteDto> settingDetail = detalleAjusteService
        // .getDetailSetting(ajuste.getIdAjuste());
        // temp.setDetalleAjuste(settingDetail);
        // detalleAjuste.push(temp);
        // }

        // return new ResponseEntity<>(
        // MensajeResponse.builder()
        // .mensaje("Registros Obtenidos:")
        // .objeto(ajustes)
        // .build(),
        // HttpStatus.OK);

        // }

        @GetMapping("settings/{id}")
        public ResponseEntity<?> showDetailsSettingsById(@PathVariable Integer id) {

                Ajuste ajuste = ajusteService.findById(id);

                ListaDetalleAjusteDto detalleAjuste = new ListaDetalleAjusteDto(id, null, null, null, null, null, id,
                                null, id, null, null);

                if (ajuste == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(detalleAjuste)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                detalleAjuste.setIdAjuste(ajuste.getIdAjuste());
                detalleAjuste.setEmpresa(ajuste.getEmpresa());
                detalleAjuste.setNombreAjuste(ajuste.getNombreAjuste());
                detalleAjuste.setAcronimo(ajuste.getAcronimo());
                detalleAjuste.setDescripcion(ajuste.getDescripcion());
                detalleAjuste.setStatus(ajuste.getStatus());
                detalleAjuste.setCreatedAt(ajuste.getCreatedAt());
                detalleAjuste.setCreatedBy(ajuste.getCreatedBy());
                detalleAjuste.setUpdatedAt(ajuste.getUpdatedAt());
                detalleAjuste.setUpdatedBy(ajuste.getUpdatedBy());

                List<DetalleAjuste> settingDetail = detalleAjusteService.getDetailSetting(id);
                detalleAjuste.setDetalleAjuste(settingDetail);

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(detalleAjuste)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("setting")
        public ResponseEntity<?> create(@RequestBody AjusteDto ajusteDto) {
                Ajuste ajusteSave = null;

                try {
                        ajusteSave = ajusteService.save(ajusteDto);
                        return new ResponseEntity<>(MensajeResponse.builder()
                                        .mensaje("CREADO")
                                        .objeto(AjusteDto.builder()
                                                        .idAjuste(ajusteSave.getIdAjuste())
                                                        .empresa(ajusteSave.getEmpresa())
                                                        .nombreAjuste(ajusteSave.getNombreAjuste())
                                                        .acronimo(ajusteSave.getAcronimo())
                                                        .descripcion(ajusteSave.getDescripcion())
                                                        .status(ajusteSave.getStatus())
                                                        .createdBy(ajusteSave.getCreatedBy())
                                                        .createdAt(ajusteSave.getCreatedAt())
                                                        .updatedBy(ajusteSave.getUpdatedBy())
                                                        .updatedAt(ajusteSave.getUpdatedAt())
                                                        .build())
                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("ERROR")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }

        }

        @PostMapping("settingdetail")
        public ResponseEntity<?> createSettingDetail(@RequestBody DetalleAjusteDto detalleAjusteDto) {
                DetalleAjuste detalleAjusteSave = null;

                try {
                        detalleAjusteSave = detalleAjusteService.save(detalleAjusteDto);
                        return new ResponseEntity<>(MensajeResponse.builder()
                                        .mensaje("CREADO")
                                        .objeto(DetalleAjusteDto.builder()
                                                        .idDetalleAjuste(detalleAjusteSave.getIdDetalleAjuste())
                                                        .ajuste(detalleAjusteSave.getAjuste())
                                                        .etiqueta(detalleAjusteSave.getEtiqueta())
                                                        .acronimo(detalleAjusteSave.getAcronimo())
                                                        .valorEntrada(detalleAjusteDto.getValorEntrada())
                                                        .valorSalida(detalleAjusteDto.getValorSalida())
                                                        .status(detalleAjusteSave.getStatus())
                                                        .createdBy(detalleAjusteSave.getCreatedBy())
                                                        .createdAt(detalleAjusteSave.getCreatedAt())
                                                        .updatedBy(detalleAjusteSave.getUpdatedBy())
                                                        .updatedAt(detalleAjusteSave.getUpdatedAt())
                                                        .build())
                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("ERROR")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }

        }

        @PutMapping("setting/{id}")
        public ResponseEntity<?> update(@RequestBody AjusteDto ajusteDto, @PathVariable Integer id) {

                Ajuste ajusteUpdate = null;
                try {
                        if (ajusteService.existsById(id)) {
                                ajusteDto.setIdAjuste(id);
                                ajusteUpdate = ajusteService.save(ajusteDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("CREADO")
                                                .objeto(AjusteDto.builder()
                                                                .idAjuste(ajusteUpdate.getIdAjuste())
                                                                .empresa(ajusteUpdate.getEmpresa())
                                                                .nombreAjuste(ajusteUpdate.getNombreAjuste())
                                                                .acronimo(ajusteUpdate.getAcronimo())
                                                                .descripcion(ajusteUpdate.getDescripcion())
                                                                .status(ajusteUpdate.getStatus())
                                                                .createdBy(ajusteUpdate.getCreatedBy())
                                                                .createdAt(ajusteUpdate.getCreatedAt())
                                                                .updatedBy(ajusteUpdate.getUpdatedBy())
                                                                .updatedAt(ajusteUpdate.getUpdatedAt()))
                                                .build(),
                                                HttpStatus.CREATED);
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

        @DeleteMapping("setting/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Ajuste ajusteDelete = ajusteService.findById(id);
                        if (ajusteDelete == null) {
                                return new ResponseEntity<>(ajusteDelete, HttpStatus.NOT_FOUND);
                        } else {
                                ajusteService.delete(ajusteDelete);
                                return new ResponseEntity<>(ajusteDelete, HttpStatus.NO_CONTENT);
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

        @DeleteMapping("settingdetail/{id}")
        public ResponseEntity<?> deleteDetail(@PathVariable Integer id) {

                try {
                        DetalleAjuste detalleAjusteDelete = detalleAjusteService.findById(id);
                        if (detalleAjusteDelete == null) {
                                return new ResponseEntity<>(detalleAjusteDelete, HttpStatus.NOT_FOUND);
                        } else {
                                detalleAjusteService.delete(detalleAjusteDelete);
                                return new ResponseEntity<>(detalleAjusteDelete, HttpStatus.NO_CONTENT);
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

        @GetMapping("settingsdetailgroup/{ajuste}")
        public ResponseEntity<?> getDetailBySettingGroup(@PathVariable String ajuste) {

                List<DetalleAjuste> detalleAjustes = detalleAjusteService
                                .getDetailBySettingGroup((ajuste).toUpperCase());

                if (detalleAjustes == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(detalleAjustes)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(detalleAjustes)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("exchangebydate/{fecha}&{moneda}")
        public ResponseEntity<?> getExchangeByDate(@PathVariable String fecha, @PathVariable String moneda) {

                List<DetalleAjuste> detalleAjustes = detalleAjusteService
                                .getExchangeByDate(fecha, moneda.toUpperCase());

                if (detalleAjustes == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(detalleAjustes)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(detalleAjustes)
                                                .build(),
                                HttpStatus.OK);

        }

}
