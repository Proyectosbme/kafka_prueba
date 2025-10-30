package com.resolutions.aplicacion.ports.in;

import java.util.List;

import com.resolutions.domain.model.TurnoModel;

public interface  IConsultarTurno {
    List<TurnoModel> consultarTurnos();
}
