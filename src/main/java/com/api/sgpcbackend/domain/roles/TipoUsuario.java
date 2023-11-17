package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tipo_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public TipoUsuario(Integer id)
    {
        this.id = id;
    }
}
