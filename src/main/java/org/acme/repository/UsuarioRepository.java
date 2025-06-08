package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.*;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {}

