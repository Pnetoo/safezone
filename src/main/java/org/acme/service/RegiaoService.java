package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Regiao;
import org.acme.repository.RegiaoRepository;

import java.util.List;

@ApplicationScoped
public class RegiaoService {
    @Inject RegiaoRepository repo;
    public void inserir(Regiao e) { repo.persist(e); }
    public void atualizar(Regiao e) { repo.getEntityManager().merge(e); }
    public void deletar(Long id) { repo.deleteById(id); }
    public Regiao buscar(Long id) { return repo.findById(id); }
    public List<Regiao> listar() { return repo.listAll(); }
}
