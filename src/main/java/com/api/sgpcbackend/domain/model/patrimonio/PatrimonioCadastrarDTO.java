package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class PatrimonioCadastrarDTO
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotNull(message = "É necessário preencher o campo tombamento")
    @Column(name = "tombamento", unique = true)
    private String tombamento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "localidade")
    private Integer localidade;

    @Column(name = "alienado")
    private Boolean alienado;
}
