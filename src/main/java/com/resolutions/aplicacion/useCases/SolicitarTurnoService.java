package com.resolutions.aplicacion.useCases;

import com.resolutions.aplicacion.ports.in.ISolicitarTurno;
import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.IDataPersist;
import com.resolutions.domain.ports.INotificadorTurno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SolicitarTurnoService implements ISolicitarTurno {

    private final IDataPersist<TurnoModel> turnoRepository;
    private final INotificadorTurno notificadorTurno;

    @Inject
    public SolicitarTurnoService(IDataPersist<TurnoModel> turnoRepository, INotificadorTurno notificadorTurno) {
        this.turnoRepository = turnoRepository;
        this.notificadorTurno = notificadorTurno;
    }

    @Override
    public void solicitarTurno(TurnoModel turno) {
        turnoRepository.guardar(turno);
        notificadorTurno.enviarNotificacion(turno);
    }

}
