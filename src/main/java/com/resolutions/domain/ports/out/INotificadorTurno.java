package com.resolutions.domain.ports.out;

import com.resolutions.domain.model.TurnoModel;

public interface  INotificadorTurno {
    void enviarNotificacion(TurnoModel turno);
    
}
