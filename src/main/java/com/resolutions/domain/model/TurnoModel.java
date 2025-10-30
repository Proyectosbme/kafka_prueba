package com.resolutions.domain.model;

import java.time.LocalDate;

public class TurnoModel {

    private final String usuario;
    private final String servicio;
    private final LocalDate fecha;
    private final String correo;

    public TurnoModel(String usuario, String servicio, LocalDate fecha, String correo) {
        this.usuario = usuario;
        this.servicio = servicio;
        this.fecha = fecha;
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServicio() {
        return servicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCorreo() {
        return correo;
    }
}
