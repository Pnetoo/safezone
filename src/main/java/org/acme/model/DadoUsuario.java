package org.acme.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DADO_USUARIO")
public class DadoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String descricao;
    public LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    public Usuario usuario;
}
