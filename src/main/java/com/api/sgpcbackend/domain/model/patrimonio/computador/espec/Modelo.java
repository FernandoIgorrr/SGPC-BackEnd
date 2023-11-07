package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo_pc")
public class Modelo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
