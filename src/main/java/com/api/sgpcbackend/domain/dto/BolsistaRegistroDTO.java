package com.api.sgpcbackend.domain.dto;

import com.api.sgpcbackend.domain.roles.TipoBolsista;
import com.api.sgpcbackend.domain.roles.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BolsistaRegistroDTO (String login,
                                   String matricula,
                                   String nome,
                                   String email,
                                   String telefone,
                                   TipoBolsista tipoBolsista,
                                   LocalDate data_chegada,
                                   LocalDate data_saida
                                    )
{

}
