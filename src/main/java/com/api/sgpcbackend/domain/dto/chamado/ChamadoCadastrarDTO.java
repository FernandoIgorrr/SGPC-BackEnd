package com.api.sgpcbackend.domain.dto.chamado;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record ChamadoCadastrarDTO(
    UUID criador,
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate data_abertura,
    String titulo,
    String descricao,
    Short localidade,
    Short tipo
) {
}
