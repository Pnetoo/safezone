package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.DadoUsuario;

@ApplicationScoped
public class DadoUsuarioRepository implements PanacheRepository<DadoUsuario> {}
