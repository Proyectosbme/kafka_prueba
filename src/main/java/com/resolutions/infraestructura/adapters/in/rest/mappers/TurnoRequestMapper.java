package com.resolutions.infraestructura.adapters.in.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.infraestructura.adapters.in.rest.dto.TurnoRequestDTO;

@Mapper(componentModel = "cdi", imports = {java.time.LocalDateTime.class, java.util.UUID.class})
public interface TurnoRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "codigo", ignore = true) 
    @Mapping(target = "fechaCreacion", expression = "java(LocalDateTime.now())")
    @Mapping(target = "horaLlamado", ignore = true)
    @Mapping(target = "horaAtendido", ignore = true)
    TurnoModel toModel(TurnoRequestDTO request);
}
