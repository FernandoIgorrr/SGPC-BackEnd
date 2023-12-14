package com.api.sgpcbackend.domain.dto.chamado;

public record ChamadoAlterarDTO(
        Integer id,
        String titulo,
        String descricao,
        Short tipo,
        Short estado

){}
