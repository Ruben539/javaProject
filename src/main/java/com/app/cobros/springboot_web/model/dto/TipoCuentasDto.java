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
public class TipoCuentasDto implements Serializable{

    private Long id;
    private String descripcion;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    @UpdateTimestamp
    private Timestamp deletedAt;
}
