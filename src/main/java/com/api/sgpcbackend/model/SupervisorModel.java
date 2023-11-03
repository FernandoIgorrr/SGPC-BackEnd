package com.api.sgpcbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Table(name = "supervisor")
@Getter
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorModel extends UsuarioModel
{
    private static final long serialVersionUID = 1L;

    @NotNull(message = "O tipo do supervisor deve ser escolhido")
    @Column(name = "tipo_supervisor")
    private Short tipo_supervisor;
}
