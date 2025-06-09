package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.acme.exception.EntidadeNaoEncontradaException;
import org.acme.model.Sensor;
import org.acme.service.SensorService;

import java.util.List;

@Path("/sensores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @Inject
    SensorService service;

    @GET
    public List<Sensor> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Sensor buscar(@PathParam("id") Long id) {
        Sensor s = service.buscar(id);
        if (s == null) throw new EntidadeNaoEncontradaException("Sensor não encontrado");
        return s;
    }

    @POST
    public Response inserir(Sensor sensor) {
        service.inserir(sensor);
        return Response.status(Response.Status.CREATED).entity(sensor).build();
    }

    @PUT
    @Path("/{id}")
    public Sensor atualizar(@PathParam("id") Long id, Sensor novo) {
        Sensor antigo = service.buscar(id);
        if (antigo == null) throw new EntidadeNaoEncontradaException("Sensor não encontrado");

        antigo.setTipo(novo.getTipo());
        antigo.setLocalizacao(novo.getLocalizacao());
        antigo.setStatus(novo.getStatus());
        antigo.setIdRegiao(novo.getIdRegiao());

        service.atualizar(antigo);
        return antigo;
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Sensor s = service.buscar(id);
        if (s == null) throw new EntidadeNaoEncontradaException("Sensor não encontrado");
        service.deletar(id);
        return Response.noContent().build();
    }
}
