package com.api.sgpcbackend.domain.dto;

import java.time.LocalDate;

public record SupervisorCadastroDTO(
        String login,
        String nome,
        String email,
        String telefone,
        Short tipo_supervisor,
        LocalDate data_chegada
){}
