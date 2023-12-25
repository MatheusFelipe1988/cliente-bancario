package com.bank.cubos.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "cliente")
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;
    private BigDecimal participacao;

    public Cliente(String nome, String sobreNome, BigDecimal participacao) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.participacao = participacao;
    }

    public Cliente() {

    }
}
