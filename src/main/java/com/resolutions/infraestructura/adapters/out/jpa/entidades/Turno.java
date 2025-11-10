package com.resolutions.infraestructura.adapters.out.jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"TURNO\"", schema = "kafka")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = true)
    private String codigo;

    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "servicio", nullable = false)
    private String servicio;

    @Column(name = "sub_servicio", nullable = false)
    private String subServicio;

    @Column(name = "hora_llamado")
    private String horaLlamado;

    @Column(name = "hora_atendido")
    private String horaAtendido;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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

    public String getHoraLlamado() {
        return horaLlamado;
    }

    public void setHoraLlamado(String horaLlamado) {
        this.horaLlamado = horaLlamado;
    }

    public String getHoraAtendido() {
        return horaAtendido;
    }

    public void setHoraAtendido(String horaAtendido) {
        this.horaAtendido = horaAtendido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
