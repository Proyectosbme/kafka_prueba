package com.resolutions.infraestructura.adapters.out.jpa;

import java.util.List;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.domain.ports.IDataPersist;
import com.resolutions.infraestructura.adapters.out.jpa.entidades.Turno;
import com.resolutions.infraestructura.adapters.out.jpa.mappers.TurnoMappers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TurnoRepositoryImpl implements IDataPersist<TurnoModel> {

    @Inject
    TurnoPanacheRepository panacheRepository;

    @Inject
    TurnoMappers mapper;

    @Override
    @Transactional
    public void guardar(TurnoModel turnoDominio) {
        Turno entity = mapper.toEntity(turnoDominio);
        panacheRepository.persist(entity);
    }

    @Override
    @Transactional
    public void update(TurnoModel dto) {
        Turno entity = mapper.toEntity(dto);
        panacheRepository.getEntityManager().merge(entity);
    }

    @Override
    @Transactional
    public void delete(TurnoModel dto) {
        Turno entity = mapper.toEntity(dto);
        panacheRepository.delete(entity);
    }

    @Override
    public TurnoModel get(String cod) {
        Turno entity = panacheRepository.findByUsuario(cod);
        return mapper.toModel(entity);
    }

    @Override
    public List<TurnoModel> getAll() {
        List<Turno> entities = panacheRepository.listAll();
        return entities.stream()
                .map(mapper::toModel)
                .toList();
    }

}
