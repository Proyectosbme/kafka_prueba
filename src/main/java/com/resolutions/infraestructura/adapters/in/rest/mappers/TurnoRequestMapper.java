package com.resolutions.infraestructura.adapters.in.rest.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.infraestructura.adapters.in.rest.dto.TurnoRequestDTO;

@Mapper(componentModel = "cdi", imports = java.time.LocalDate.class)
public interface TurnoRequestMapper {

    @Mapping(target = "fecha", expression = "java(LocalDate.now())")
    TurnoModel toModel(TurnoRequestDTO request);
}