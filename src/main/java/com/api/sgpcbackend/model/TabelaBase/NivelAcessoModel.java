package com.api.sgpcbackend.model.TabelaBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "nivel_acesso")
public class NivelAcessoModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao",length = 20, unique = true)
    @NotNull(message = "É necessário descrever o novo nivel de acesso")
    private String login;
}
