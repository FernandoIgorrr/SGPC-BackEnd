package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_patrimonio")
public class TipoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
