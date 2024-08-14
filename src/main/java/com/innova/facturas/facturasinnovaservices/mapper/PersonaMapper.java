package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.PersonaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Persona;

public class PersonaMapper {

    public static PersonaDto mapToPersonaDto(Persona persona) {
        return new PersonaDto(
                persona.getIdPersona(),
                persona.getNombrePersona(),
                persona.getApellidoPersona(),
                persona.getTelefonoPersona(),
                persona.getCiPersona(),
                persona.getStatusPersona(),
                persona.getCreatedBy(),
                persona.getCreatedAt(),
                persona.getUpdatedBy(),
                persona.getUpdatedAt());
    }

    public static Persona mapToPersona(PersonaDto personaDto) {
        return new Persona(
                personaDto.getIdPersona(),
                personaDto.getNombrePersona(),
                personaDto.getApellidoPersona(),
                personaDto.getTelefonoPersona(),
                personaDto.getCiPersona(),
                personaDto.getStatusPersona(),
                personaDto.getCreatedBy(),
                personaDto.getCreatedAt(),
                personaDto.getUpdatedBy(),
                personaDto.getUpdatedAt());
    }

}
