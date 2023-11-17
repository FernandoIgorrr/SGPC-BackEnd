package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelo_pc")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Modelo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public Modelo(Short id)
    {
        this.id = id;
    }
}
