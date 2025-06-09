package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.*;
import org.acme.model.*;
import org.acme.service.*;

import java.util.List;

@Path("/alertas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlertaResource {

    @Inject
    AlertaService service;

    @GET
    public List<Alerta> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Alerta buscar(@PathParam("id") Long id) {
        Alerta alerta = service.buscar(id);
        if (alerta == null) throw new EntidadeNaoEncontradaException("Alerta não encontrado");
        return alerta;
    }

    @POST
    public Response inserir(Alerta alerta) {
        service.inserir(alerta);
        return Response.status(Response.Status.CREATED).entity(alerta).build();
    }

    @PUT
    @Path("/{id}")
    public Alerta atualizar(@PathParam("id") Long id, Alerta nova) {
        Alerta antiga = service.buscar(id);
        if (antiga == null) throw new EntidadeNaoEncontradaException("Alerta não encontrado");

        antiga.setMensagem(nova.getMensagem());
        antiga.setNivel(nova.getNivel());
        antiga.setDataHora(nova.getDataHora());
        antiga.setIdSensor(nova.getIdSensor());
        antiga.setIdUsuario(nova.getIdUsuario());

        service.atualizar(antiga);
        return antiga;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Alerta alerta = service.buscar(id);
        if (alerta == null) throw new EntidadeNaoEncontradaException("Alerta não encontrado");
        service.deletar(id);
        return Response.noContent().build();
    }
}
