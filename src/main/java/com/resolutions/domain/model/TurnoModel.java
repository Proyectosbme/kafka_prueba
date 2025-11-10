package com.resolutions.domain.model;
import java.time.LocalDateTime;

public class TurnoModel {
   private final Long id;
    private String codigo;
    private final LocalDateTime fechaCreacion;
    private final String estado;
    private final String servicio;
    private final String subServicio;
    private final LocalDateTime horaLlamado;
    private final LocalDateTime horaAtendido;   

    public TurnoModel(Long id, String codigo, LocalDateTime fechaCreacion, String estado, String servicio,
            String subServicio, LocalDateTime horaLlamado, LocalDateTime horaAtendido) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.servicio = servicio;
        this.subServicio = subServicio;
        this.horaLlamado = horaLlamado;
        this.horaAtendido = horaAtendido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public String getServicio() {
        return servicio;
    }

    public String getSubServicio() {
        return subServicio;
    }

    public LocalDateTime getHoraLlamado() {
        return horaLlamado;
    }

    public LocalDateTime getHoraAtendido() {
        return horaAtendido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }
}
