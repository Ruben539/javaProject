package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.PersonaDao;
import com.innova.facturas.facturasinnovaservices.model.dto.PersonaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Persona;
import com.innova.facturas.facturasinnovaservices.services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Persona> getAllPersonas() {
        return (List) personaDao.findAll();
    }

    @Transactional
    @Override
    public Persona save(PersonaDto personaDto) {

        Persona persona = Persona.builder()
                .idPersona(personaDto.getIdPersona())
                .nombrePersona(personaDto.getNombrePersona())
                .apellidoPersona(personaDto.getApellidoPersona())
                .telefonoPersona(personaDto.getTelefonoPersona())
                .ciPersona(personaDto.getCiPersona())
                .statusPersona(personaDto.getStatusPersona())
                .createdAt(personaDto.getCreatedAt())
                .createdBy(personaDto.getCreatedBy())
                .updatedAt(personaDto.getUpdatedAt())
                .updatedBy(personaDto.getUpdatedBy())
                .build();
        return personaDao.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public Persona findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    public boolean existsById(Integer id) {
        return personaDao.existsById(id);
    }

}
