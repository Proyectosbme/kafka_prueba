package com.resolutions.infraestructura.adapters.in.rest.dto;

public class TurnoRequestDTO {
    private String servicio;
    private String subServicio;
    private String estado;
    private String correo;

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getSubServicio() {
        return subServicio;
    }

    public void setSubServicio(String subServicio) {
        this.subServicio = subServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
