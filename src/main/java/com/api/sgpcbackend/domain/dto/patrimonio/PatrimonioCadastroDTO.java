package com.api.sgpcbackend.domain.dto.patrimonio;


import java.util.UUID;

public record PatrimonioCadastroDTO
        (
        UUID id,
        String tombamento,
        String descricao,
        Short estado,
        Short tipo,
        Short localidade,
        Boolean alienado
    ){}
