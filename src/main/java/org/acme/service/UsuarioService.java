package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;

import java.util.List;

@ApplicationScoped
public class UsuarioService {
    @Inject
    UsuarioRepository repo;
    public void inserir(Usuario e) { repo.persist(e); }
    public void atualizar(Usuario e) { repo.getEntityManager().merge(e); }
    public void deletar(Long id) { repo.deleteById(id); }
    public Usuario buscar(Long id) { return repo.findById(id); }
    public List<Usuario> listar() { return repo.listAll(); }
}
