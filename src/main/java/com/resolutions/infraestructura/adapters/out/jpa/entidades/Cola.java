package com.resolutions.infraestructura.adapters.out.jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"COLA\"", schema = "kafka")
public class Cola {
       @Id
    private String id;

    @Column(name = "sub_servicio_id", nullable = false)
    private String subServicioId;
}
