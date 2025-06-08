package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.*;
import org.acme.model.*;
import org.acme.service.*;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @GET
    public List<Usuario> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Usuario buscar(@PathParam("id") Long id) {
        Usuario u = service.buscar(id);
        if (u == null) throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        return u;
    }

    @POST
    public Response inserir(Usuario usuario) {
        service.inserir(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @PUT
    @Path("/{id}")
    public Usuario atualizar(@PathParam("id") Long id, Usuario novo) {
        Usuario antigo = service.buscar(id);
        if (antigo == null) throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        antigo.setNome(novo.getNome());
        antigo.setEmail(novo.getEmail());
        antigo.setTelefone(novo.getTelefone());
        antigo.setTipo(novo.getTipo());
        service.atualizar(antigo);
        return antigo;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Usuario u = service.buscar(id);
        if (u == null) throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        service.deletar(id);
        return Response.noContent().build();
    }
}
