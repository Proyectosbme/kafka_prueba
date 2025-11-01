package com.resolutions.infraestructura.adapters.out.jpa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.resolutions.domain.model.TurnoModel;
import com.resolutions.infraestructura.adapters.out.jpa.entidades.Turno;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TurnoMappers {

    @Mapping(target = "fechaCreacion", source = "fechaCreacion", qualifiedByName = "stringToDateTime")
    @Mapping(target = "horaLlamado", source = "horaLlamado", qualifiedByName = "stringToDateTime")
    @Mapping(target = "horaAtendido", source = "horaAtendido", qualifiedByName = "stringToDateTime")
    TurnoModel toModel(Turno entity);

    @Mapping(target = "fechaCreacion", source = "fechaCreacion", qualifiedByName = "dateTimeToString")
    @Mapping(target = "horaLlamado", source = "horaLlamado", qualifiedByName = "dateTimeToString")
    @Mapping(target = "horaAtendido", source = "horaAtendido", qualifiedByName = "dateTimeToString")
    Turno toEntity(TurnoModel model);

    @Named("stringToDateTime")
    static LocalDateTime stringToDateTime(String value) {
        return value != null ? LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null;
    }

    @Named("dateTimeToString")
    static String dateTimeToString(LocalDateTime value) {
        return value != null ? value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null;
    }
}
