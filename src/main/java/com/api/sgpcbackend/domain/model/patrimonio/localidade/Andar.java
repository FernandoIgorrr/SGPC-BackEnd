package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;

@Entity
@Table(name = "andar")
public class Andar
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "predio")
    private Predio predio;
}
