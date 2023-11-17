package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "tipo_patrimonio")
@NoArgsConstructor
@AllArgsConstructor
public class TipoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public TipoPatrimonio(Short id)
    {
        this.id = id;
    }
}
