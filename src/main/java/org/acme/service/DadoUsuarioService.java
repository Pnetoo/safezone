package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DadoUsuario;
import org.acme.repository.DadoUsuarioRepository;

import java.util.List;

@ApplicationScoped
public class DadoUsuarioService {
    @Inject DadoUsuarioRepository repo;
    public void inserir(DadoUsuario e) { repo.persist(e); }
    public void atualizar(DadoUsuario e) { repo.getEntityManager().merge(e); }
    public void deletar(Long id) { repo.deleteById(id); }
    public DadoUsuario buscar(Long id) { return repo.findById(id); }
    public List<DadoUsuario> listar() { return repo.listAll(); }
}
