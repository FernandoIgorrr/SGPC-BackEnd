package com.api.sgpcbackend.domain.dto.patrimonio;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record ManejoCadastroDTO (UUID patrimonio, UUID usuario, Short comodo_anterior, Short comodo_posterior,@JsonFormat(pattern = "dd-MM-yyyy")
LocalDate data_manejo){
}
