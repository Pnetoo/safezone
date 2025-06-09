package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.EntidadeNaoEncontradaException;
import org.acme.model.Regiao;
import org.acme.service.RegiaoService;

import java.util.List;

@Path("/regioes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegiaoResource {

    @Inject
    RegiaoService service;

    @GET
    public List<Regiao> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Regiao buscar(@PathParam("id") Long id) {
        Regiao r = service.buscar(id);
        if (r == null) throw new EntidadeNaoEncontradaException("Região não encontrada");
        return r;
    }

    @POST
    public Response inserir(Regiao regiao) {
        service.inserir(regiao);
        return Response.status(Response.Status.CREATED).entity(regiao).build();
    }

    @PUT
    @Path("/{id}")
    public Regiao atualizar(@PathParam("id") Long id, Regiao nova) {
        Regiao antiga = service.buscar(id);
        if (antiga == null) throw new EntidadeNaoEncontradaException("Região não encontrada");
        antiga.setNome(nova.getNome());
        antiga.setDescricao(nova.getDescricao());
        service.atualizar(antiga);
        return antiga;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Regiao r = service.buscar(id);
        if (r == null) throw new EntidadeNaoEncontradaException("Região não encontrada");
        service.deletar(id);
        return Response.noContent().build();
    }
}
