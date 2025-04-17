package com.multirao.oftalmo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;
    private String sinalpago;
    private String valorAPagar;

    // data da compra
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate purchaseDate;

    // data da entrega
    private LocalDate dateDelivery;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Client client;

}
