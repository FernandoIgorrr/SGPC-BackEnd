package com.api.sgpcbackend.model.TabelaBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Table(name = "tipo_usuairo")
public class TipoUsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao",length = 20, unique = true)
    @NotNull(message = "É necessário descrever o novo tipo de usuario")
    private String login;
}
