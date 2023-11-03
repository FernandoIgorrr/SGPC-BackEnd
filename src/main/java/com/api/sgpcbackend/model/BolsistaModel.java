package com.api.sgpcbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Table(name = "bolsista")
@EqualsAndHashCode(of = {"matricula"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BolsistaModel extends UsuarioModel{

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "A matricula do bolsista deve ser preenchida")
    @Column(name = "matricula", length = 12, unique = true)
    private String matricula;

    @NotNull(message = "O tipo do bolsista deve ser escolhido")
    private Short tipo_bolsista;
}
