package com.app.cobros.springboot_web.model.entity;


import java.io.Serializable;
import java.sql.Timestamp;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "tipo_cuentas")
public class TipoCuentas implements Serializable {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;

     @Column(name = "descripcion")
     private String descripcion;
 
     @Column(name = "created_at")
     @CreationTimestamp // with this annotation, hibernate will automatically manage the timestamps
     private Timestamp createdAt;
 
     @Column(name = "updated_at")
     @UpdateTimestamp // with this annotation, hibernate will automatically manage the timestamps
     private Timestamp updatedAt;
 
     @Column(name = "deleted_at")
     @UpdateTimestamp // with this annotation, hibernate will automatically manage the timestamps
     private Timestamp deletedAt;


}
