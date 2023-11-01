package com.api.sgpcbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login",length = 25, unique = true)
    private String login;

    @Size(min = 8)
    @Column(name = "senha", length = 80, table = "usuario")
    private String senha;

    @Column(name = "nome", length = 100, table = "usuario")
    private String nome;

    @Column(name = "email", table = "usuario")
    private String email;

    @Column(name = "telefone", table = "usuario")
    private String telefone;

    @Column(name = "ativo", table = "usuario")
    private Boolean ativo;

    @Column(name = "nivel_acesso", table = "usuario")
    private Integer nivel_acesso;

    @Column(name = "data_chegada", table = "usuario")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_chegada;

    @Column(name = "data_saida", table = "usuario")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_saida;
}
