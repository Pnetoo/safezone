package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.*;
import org.acme.model.*;
import org.acme.service.*;

import java.util.List;

@Path("/dados-usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DadoUsuarioResource {

    @Inject
    DadoUsuarioService service;

    @GET
    public List<DadoUsuario> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public DadoUsuario buscar(@PathParam("id") Long id) {
        DadoUsuario dado = service.buscar(id);
        if (dado == null) throw new EntidadeNaoEncontradaException("Dado de usuário não encontrado");
        return dado;
    }

    @POST
    public Response inserir(DadoUsuario dadoUsuario) {
        service.inserir(dadoUsuario);
        return Response.status(Response.Status.CREATED).entity(dadoUsuario).build();
    }

    @PUT
    @Path("/{id}")
    public DadoUsuario atualizar(@PathParam("id") Long id, DadoUsuario novo) {
        DadoUsuario antigo = service.buscar(id);
        if (antigo == null) throw new EntidadeNaoEncontradaException("Dado de usuário não encontrado");
        antigo.descricao = novo.descricao;
        antigo.dataHora = novo.dataHora;
        antigo.usuario = novo.usuario;
        service.atualizar(antigo);
        return antigo;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        DadoUsuario dado = service.buscar(id);
        if (dado == null) throw new EntidadeNaoEncontradaException("Dado de usuário não encontrado");
        service.deletar(id);
        return Response.noContent().build();
    }
}