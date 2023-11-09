package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_patrimonio")
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public EstadoPatrimonio(Integer id)
    {
        this.id = id;
    }
}
