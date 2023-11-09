package com.api.sgpcbackend.domain.dto.patrimonio;


public record PatrimonioCadastroDTO(

     String tombamento,

     String descricao,

     Integer estado,

     Integer tipo,

     Integer localidade,

     Boolean alienado

    )
{
}
