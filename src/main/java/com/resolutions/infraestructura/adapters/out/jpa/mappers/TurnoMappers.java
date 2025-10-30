package com.resolutions.infraestructura.adapters.out.jpa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.infraestructura.adapters.out.jpa.entidades.Turno;

@Mapper (componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TurnoMappers {
    Turno toEntity(TurnoModel model);
    TurnoModel toModel(Turno entity);
}
