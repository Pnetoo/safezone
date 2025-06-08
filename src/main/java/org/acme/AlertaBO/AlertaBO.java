package org.acme.AlertaBO;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.exception.*;
import org.acme.model.*;
import org.acme.service.AlertaService;

import java.util.List;

@ApplicationScoped
public class AlertaBO {

    @Inject
    AlertaService alertaService;

    // Retorna apenas alertas de nível crítico (nível >= 3)
    public List<Alerta> listarAlertasCriticos() {
        return alertaService.listar().stream()
                .filter(alerta -> alerta.getNivel() != null && alerta.getNivel() >= 3)
                .toList();
    }

    // Insere alerta com validação de nível
    public void inserirComValidacao(Alerta alerta) {
        if (alerta.getNivel() == null || alerta.getNivel() < 1 || alerta.getNivel() > 5) {
            throw new IllegalArgumentException("Nível do alerta deve estar entre 1 e 5.");
        }
        alertaService.inserir(alerta);
    }

    // Buscar com validação
    public Alerta buscarOuErro(Long id) {
        Alerta alerta = alertaService.buscar(id);
        if (alerta == null) {
            throw new EntidadeNaoEncontradaException("Alerta com ID " + id + " não encontrado.");
        }
        return alerta;
    }
}