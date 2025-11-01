package clases;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.resolutions.infraestructura.adapters.out.jpa.entidades.Turno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Notificacion {

    private final Emitter<String> notificacionEmitter;

    @Inject
    public Notificacion(@Channel("notificaciones-turno") Emitter<String> notificacionEmitter) {
        this.notificacionEmitter = notificacionEmitter;
    }

    public void enviarNotificacionKafka(Turno turno) {
        String mensaje = String.format(
                "Notificación: %s se ha enviado la notificación por el turno solicitado para el %s",
                turno.getCodigo(), turno.getEstado());

        notificacionEmitter.send(mensaje);
    }
}
