package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;

public record ComputadorCadastroDTO(
        String tombamento,
        String descricao,
        Short estado,
        Short localidade,
        Boolean alienado,
        String serial,
        Short modelo,
        Short sistema_operacional,
        Short ram,
        Short ram_ddr,
        Short hd
)
{}
