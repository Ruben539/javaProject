package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.PersonaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Persona;

public interface PersonaService {

    Persona save(PersonaDto personaDto);

    Persona findById(Integer id);

    void delete(Persona persona);

    List<Persona> getAllPersonas();

    boolean existsById(Integer id);

}
