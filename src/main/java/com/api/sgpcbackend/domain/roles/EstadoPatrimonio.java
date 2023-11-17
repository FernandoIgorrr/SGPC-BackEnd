package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "estado_patrimonio")
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPatrimonio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public EstadoPatrimonio(Short id)
    {
        this.id = id;
    }
}
