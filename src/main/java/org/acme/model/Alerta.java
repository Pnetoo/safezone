package org.acme.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTA")
public class Alerta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String mensagem;
    public Integer nivel;
    public LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR")
    public Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    public Usuario usuario;
}
