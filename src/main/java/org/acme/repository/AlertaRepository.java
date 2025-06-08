package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Alerta;

@ApplicationScoped
public class AlertaRepository implements PanacheRepository<Alerta> {}
