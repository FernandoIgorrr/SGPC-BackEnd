package com.api.sgpcbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Table(name = "usuario")
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "tipo_usuario",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class UsuarioModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login",length = 25, unique = true)
    private String login;

    @Setter
    @Size(min = 8)
    @Column(name = "senha", length = 80)
    private String senha;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 12)
    private String telefone;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "nivel_acesso")
    private Short nivel_acesso;

    @Column(name = "tipo_usuario")
    private Short tipo_usuario;

    @Column(name = "data_chegada")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_chegada;

    @Column(name = "data_saida", table = "usuario")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data_saida;
}
