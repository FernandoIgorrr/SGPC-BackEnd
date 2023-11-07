package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_patrimonio")
public class EstadoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
