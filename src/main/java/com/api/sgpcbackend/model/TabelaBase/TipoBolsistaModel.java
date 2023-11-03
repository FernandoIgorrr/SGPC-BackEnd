package com.api.sgpcbackend.model.TabelaBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_bolsista")
public class TipoBolsistaModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao",length = 20, unique = true)
    @NotNull(message = "É necessário descrever o novo tipo de bolsista")
    private String descricao;
}
