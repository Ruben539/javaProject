package com.app.cobros.springboot_web.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class ClienteDto implements Serializable {
    
    private Integer id;
    private Integer cedula;
    private String nombre;
    private String correo;
    private Integer estadoId;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @UpdateTimestamp
    private Timestamp deletedAt;
}
