package com.resolutions.domain.ports;

import com.resolutions.domain.model.TurnoModel;

public interface  INotificadorTurno {
    void enviarNotificacion(TurnoModel turno);
    
}
