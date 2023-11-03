package com.api.sgpcbackend.model.TabelaBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "nivel_acesso")
public class NivelAcessoModel
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao",length = 20, unique = true)
    private String descricao;
}