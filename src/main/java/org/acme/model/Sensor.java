package org.acme.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "SENSOR")
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String tipo;
    public String localizacao;
    public String status;

    @ManyToOne
    @JoinColumn(name = "ID_REGIAO")
    public Regiao regiao;
}
