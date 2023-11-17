package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "andar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Andar
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "predio")
    private Predio predio;
}
