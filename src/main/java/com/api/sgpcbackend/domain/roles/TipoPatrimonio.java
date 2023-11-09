package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tipo_patrimonio")
@NoArgsConstructor
public class TipoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public TipoPatrimonio(Integer id)
    {
        this.id = id;
    }
}
