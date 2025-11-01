package com.resolutions.infraestructura.adapters.out.jpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "\"PUESTO\"", schema = "kafka")
public class Puesto {
        @Id
    private String id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo_servicio", nullable = false)
    private String tipoServicio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }


    
}
