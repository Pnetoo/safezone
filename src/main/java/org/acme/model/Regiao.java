package org.acme.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "REGIAO")
public class Regiao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String descricao;
}
