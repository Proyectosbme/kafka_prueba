package com.resolutions.infraestructura.adapters.out.kafka;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.out.INotificadorTurno;

import jakarta.inject.Inject;

public class NotificadorKafka implements INotificadorTurno {

    private final Emitter<TurnoModel> emitter;

    @Inject
    public NotificadorKafka(@Channel("notificaciones-turno") Emitter<TurnoModel> emitter) {
        this.emitter = emitter;
    }

    @Override
    public void enviarNotificacion(TurnoModel turno) {
        emitter.send(turno);
    }
}
