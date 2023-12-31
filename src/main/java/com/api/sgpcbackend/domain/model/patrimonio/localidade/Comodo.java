package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "comodo")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Comodo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "andar")
    private Andar andar;

    public Comodo(Short id)
    {
        this.id = id;
    }
}
