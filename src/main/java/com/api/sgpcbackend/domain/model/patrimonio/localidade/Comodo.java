package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "comodo")
@NoArgsConstructor
public class Comodo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "andar")
    private Andar andar;

    public Comodo(Integer id)
    {
        this.id = id;
    }
}
