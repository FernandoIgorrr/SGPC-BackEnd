package com.api.sgpcbackend.domain.dto.patrimonio;

import java.util.UUID;

public record ComputadorCadastroDTO(
        UUID id,
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
