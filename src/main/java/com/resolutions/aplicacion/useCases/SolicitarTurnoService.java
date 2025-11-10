package com.resolutions.aplicacion.usecases;

import com.resolutions.aplicacion.ports.out.IDataPersist;
import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.out.INotificadorTurno;
import com.resolutions.domain.ports.out.ISolicitarTurno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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
    @Transactional
    public void solicitarTurno(TurnoModel turno) {
        turno = turnoRepository.guardar(turno);
        Long idGenerado = turno.getId();
        String codigo = generarCodigo(idGenerado, turno.getServicio(), turno.getSubServicio());
        turno.setCodigo(codigo);
        turnoRepository.update(turno);
        notificadorTurno.enviarNotificacion(turno);
    }

    private String generarCodigo(Long id, String servicio, String subServicio) {
        String letraServicio = servicio != null && !servicio.isEmpty()
                ? servicio.substring(0, 1).toUpperCase()
                : "X";
        String letraSub = subServicio != null && !subServicio.isEmpty()
                ? subServicio.substring(0, 1).toUpperCase()
                : "X";
        return id + "-" + letraServicio + letraSub;
    }

}
