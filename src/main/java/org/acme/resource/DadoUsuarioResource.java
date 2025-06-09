package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.EntidadeNaoEncontradaException;
import org.acme.model.DadoUsuario;
import org.acme.service.DadoUsuarioService;

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
        DadoUsuario d = service.buscar(id);
        if (d == null) throw new EntidadeNaoEncontradaException("Dado do usuário não encontrado");
        return d;
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
        if (antigo == null) throw new EntidadeNaoEncontradaException("Dado do usuário não encontrado");

        antigo.setDescricao(novo.getDescricao());
        antigo.setDataHora(novo.getDataHora());
        antigo.setIdUsuario(novo.getIdUsuario());

        service.atualizar(antigo);
        return antigo;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        DadoUsuario d = service.buscar(id);
        if (d == null) throw new EntidadeNaoEncontradaException("Dado do usuário não encontrado");
        service.deletar(id);
        return Response.noContent().build();
    }
}
