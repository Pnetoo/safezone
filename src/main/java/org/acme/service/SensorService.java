package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.*;
import org.acme.repository.*;

import java.util.List;

@ApplicationScoped
public class SensorService {
    @Inject SensorRepository repo;
    public void inserir(Sensor e) { repo.persist(e); }
    public void atualizar(Sensor e) { repo.getEntityManager().merge(e); }
    public void deletar(Long id) { repo.deleteById(id); }
    public Sensor buscar(Long id) { return repo.findById(id); }
    public List<Sensor> listar() { return repo.listAll(); }
}

