package com.resolutions.aplicacion.useCases;

import java.util.List;

import com.resolutions.aplicacion.ports.in.IConsultarTurno;
import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.out.IDataPersist;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConsultarTurno implements IConsultarTurno {

    private final IDataPersist<TurnoModel> turnoRepository;

    @Inject
    public ConsultarTurno(IDataPersist<TurnoModel> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<TurnoModel> consultarTurnos() {
       return turnoRepository.getAll();
    }

}
