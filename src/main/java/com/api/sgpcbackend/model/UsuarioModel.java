package com.api.sgpcbackend.model;

import com.api.sgpcbackend.model.TabelaBase.NivelAcessoModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Table(name = "usuario")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public abstract class UsuarioModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login",length = 25, unique = true)
    @NotNull(message = "É necessário preencher a senha do usuário")
    private String login;

    @Size(min = 8)
    @Column(name = "senha", length = 80)
    private String senha;

    @Column(name = "nome", length = 100)
    @NotNull(message = "É necessário preencher o nome do usuário")
    private String nome;

    @Column(name = "email", length = 50, unique = true)
    @NotNull(message = "É necessário preencher o E-mail do usuário")
    private String email;

    @Column(name = "telefone", length = 12)
    private String telefone;

    @Column(name = "ativo")
    private Boolean status;

    @ManyToOne()
    @JoinColumn(name = "nivel_acesso")
    private NivelAcessoModel nivel_acesso;

    @Column(name = "tipo_usuario")
    @NotNull(message = "Selecione o tipo do usuário")
    private Short tipo_usuario;

    @Column(name = "data_chegada")
    @NotNull(message = "A data de início das atividades do usuário deve ser inserida")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_chegada;

    @Column(name = "data_saida", table = "usuario")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_saida;
}
