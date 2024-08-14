package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Persona;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {

    private Integer idUser;
    private Integer idEmpresa;
    private Rol rol;
    private String username;
    private String password;
    private Date lastLogin;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private Persona persona;
    private String statusUser;
    private Integer createdBy;

}
