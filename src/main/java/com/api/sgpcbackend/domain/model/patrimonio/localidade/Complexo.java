package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;

@Entity
@Table(name = "complexo")
public class Complexo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;
}
