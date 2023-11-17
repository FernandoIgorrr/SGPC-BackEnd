package com.api.sgpcbackend.domain.dto;

import java.time.LocalDate;

public record BolsistaCadastroDTO(
        String login,
        String matricula,
        String nome,
        String email,
        String telefone,
        Short tipo_bolsista,
        LocalDate data_chegada
        ) {}
