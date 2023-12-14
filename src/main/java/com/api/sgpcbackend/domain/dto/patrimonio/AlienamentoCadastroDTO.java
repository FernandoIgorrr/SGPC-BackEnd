package com.api.sgpcbackend.domain.dto.patrimonio;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record AlienamentoCadastroDTO(
        UUID patrimonio,
        UUID usuario,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate data
) {
}
