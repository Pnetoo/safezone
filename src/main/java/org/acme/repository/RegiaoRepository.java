package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Regiao;

@ApplicationScoped
public class RegiaoRepository implements PanacheRepository<Regiao> {}
