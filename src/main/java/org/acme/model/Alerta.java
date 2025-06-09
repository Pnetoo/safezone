package org.acme.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou SEQUENCE conforme seu banco
    private Long id;

    @Column(name = "MENSAGEM", length = 200)
    private String mensagem;

    @Column(name = "NIVEL")
    private Integer nivel;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "ID_SENSOR")
    private Long idSensor;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Long getIdSensor() { return idSensor; }
    public void setIdSensor(Long idSensor) { this.idSensor = idSensor; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}
