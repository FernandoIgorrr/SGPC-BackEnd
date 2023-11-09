package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;

public record ComputadorCadastroDTO(
        String tombamento,

        String descricao,

        Integer estado,

        //Integer tipo,

        Integer localidade,

        Boolean alienado,

        String serial,

        Integer modelo,

        Integer sistema_operacional,

        Integer ram,

        Integer ram_ddr,

        Integer hd
)
{

}
