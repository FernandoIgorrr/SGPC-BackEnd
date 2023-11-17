package com.api.sgpcbackend.domain.dto.patrimonio;


public record PatrimonioCadastroDTO(
     String tombamento,
     String descricao,
     Short estado,
     Short tipo,
     Short localidade,
     Boolean alienado
    )
{}
