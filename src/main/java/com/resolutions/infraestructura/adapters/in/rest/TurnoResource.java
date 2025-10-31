package com.resolutions.infraestructura.adapters.in.rest;

import java.util.List;

import org.jboss.logging.Logger;

import com.resolutions.aplicacion.ports.in.IConsultarTurno;
import com.resolutions.aplicacion.ports.in.ISolicitarTurno;
import com.resolutions.domain.model.TurnoModel;
import com.resolutions.infraestructura.adapters.in.rest.dto.TurnoRequestDTO;
import com.resolutions.infraestructura.adapters.in.rest.mappers.TurnoRequestMapper;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/turnos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TurnoResource {

    private static final Logger LOG = Logger.getLogger(TurnoResource.class);

    @Inject
    ISolicitarTurno solicitarTurno;

    @Inject
    TurnoRequestMapper requestMapper;

    @Inject
    IConsultarTurno consultarTurno;

    @POST
    @Path("/recibirTurno")
    @RolesAllowed("admin")
    public void solicitarTurno(TurnoRequestDTO request) {
        try {
            LOG.infof("Recibiendo solicitud de turno: usuario=%s, servicio=%s, fecha=%s, correo=%s",
                    request.usuario, request.servicio, request.correo);

            TurnoModel turno = requestMapper.toModel(request);

            solicitarTurno.solicitarTurno(turno);
            LOG.info("Turno procesado correctamente.");

        } catch (Exception e) {
            LOG.error("Error al procesar el turno", e);
            throw e; // opcional: puedes lanzar una excepción HTTP si quieres
        }
    }

    @GET
    @Path("/consultar")
    @RolesAllowed({"user", "admin"})
    public List<TurnoModel> consultarTurnos() {
        try {
            LOG.info("Ingresando en la consulta");
            List<TurnoModel> turnos = consultarTurno.consultarTurnos();
            LOG.info("Fin de la consulta");
            return turnos;

        } catch (Exception e) {
            LOG.error("Error al consultar el turno", e);
            throw e; // opcional: puedes lanzar una excepción HTTP si quieres
        }
    }
}
