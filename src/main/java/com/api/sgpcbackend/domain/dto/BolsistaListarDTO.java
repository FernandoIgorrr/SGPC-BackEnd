package com.api.sgpcbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Data
@Table(name = "bolsistas_completo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BolsistaListarDTO
{
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "status")
    private String status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_chegada")
    LocalDate data_chegada;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_saida")
    LocalDate data_saida;
}
