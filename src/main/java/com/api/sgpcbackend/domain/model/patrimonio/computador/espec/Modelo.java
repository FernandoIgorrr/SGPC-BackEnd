package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelo_pc")
@AllArgsConstructor
@NoArgsConstructor
public class Modelo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public Modelo(Integer id)
    {
        this.id = id;
    }
}
