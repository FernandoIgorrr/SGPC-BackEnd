package com.api.sgpcbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.UUID;

public record BolsistaCadastroDTO(
        UUID id,
        String login,
        String matricula,
        String nome,
        String email,
        String telefone,
        Short tipo_bolsista,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate data_chegada
        ) {}
