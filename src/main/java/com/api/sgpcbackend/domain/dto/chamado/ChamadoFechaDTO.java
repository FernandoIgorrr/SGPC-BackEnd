package com.api.sgpcbackend.domain.dto.chamado;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record ChamadoFechaDTO(
        Integer id,
        UUID fechador,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate data_fechamento
){}
