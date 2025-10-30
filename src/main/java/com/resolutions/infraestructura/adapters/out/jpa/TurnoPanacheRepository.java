package com.resolutions.infraestructura.adapters.out.jpa;


import com.resolutions.infraestructura.adapters.out.jpa.entidades.Turno;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TurnoPanacheRepository implements PanacheRepository<Turno> {
 public Turno findByUsuario(String usuario) {
        return find("usuario", usuario).firstResult();
    }
    
}
