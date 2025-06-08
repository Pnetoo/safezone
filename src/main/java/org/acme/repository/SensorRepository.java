package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Sensor;

@ApplicationScoped
public class SensorRepository implements PanacheRepository<Sensor> {}
