package com.resolutions.infraestructura.adapters.out.kafka;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.out.INotificadorTurno;

import jakarta.inject.Inject;

public class NotificadorKafka implements INotificadorTurno{
    @Inject
    @Channel("notificaciones-turno")
    Emitter<String> emitter;

    @Override
    public void enviarNotificacion(TurnoModel turno) {
        String mensaje = String.format(
            "Notificación: %s solicitó el servicio %s para el %s",
            turno.getCorreo(), turno.getServicio(), turno.getFecha()
        );
        emitter.send(mensaje);
    }
}
