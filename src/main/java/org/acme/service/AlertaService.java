package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Alerta;
import org.acme.repository.AlertaRepository;

import java.util.List;

@ApplicationScoped
public class AlertaService {
    @Inject AlertaRepository repo;
    public void inserir(Alerta e) { repo.persist(e); }
    public void atualizar(Alerta e) { repo.getEntityManager().merge(e); }
    public void deletar(Long id) { repo.deleteById(id); }
    public Alerta buscar(Long id) { return repo.findById(id); }
    public List<Alerta> listar() { return repo.listAll(); }
}
