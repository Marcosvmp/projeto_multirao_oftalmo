package com.multirao.oftalmo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Entity
@Table(name = "tb_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean tratamentoAR;
    private boolean visaoSimples;
    private boolean incolor;
    private boolean biFocal;
    private boolean multifocal;
    private boolean policarbonato;
    private boolean filtroAzul;
    private boolean hoya;
    private boolean varilux;
    private boolean zeiss;
    private String tipoArmacao;
    private String refArmacao;
    private String valorArmacao;
    private String obsLente;
    private String valorLente;
    private int quantidadeArmacao;
    private int quantidadeLente;

    // Longe olho DIREITO
    private String longeEsfericoOD;
    private String longeCilindricoOD;
    private String longeEixoOD;
    private String longeDnpOD;
    private String longeAlturaOD;

    // perto olho DIREITO
    private String pertoEsfericoOD;
    private String pertoCilindricoOD;
    private String pertoEixoOD;
    private String pertoDnpOD;
    private String pertoAlturaOD;

    // Longe olho ESQUERDO
    private String longeEsfericoOE;
    private String longeCilindricoOE;
    private String longeEixoOE;
    private String longeDnpOE;
    private String longeAlturaOE;

    // perto olho ESQUERDO
    private String pertoEsfericoOE;
    private String pertoCilindricoOE;
    private String pertoEixoOE;
    private String pertoDnpOE;
    private String pertoAlturaOE;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
