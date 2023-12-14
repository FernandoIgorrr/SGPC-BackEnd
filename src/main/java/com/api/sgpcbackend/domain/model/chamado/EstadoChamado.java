package com.api.sgpcbackend.domain.model.chamado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "estado_chamado")
@NoArgsConstructor
@AllArgsConstructor
public class EstadoChamado
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public EstadoChamado(Short id)
    {
        this.id = id;
    }
}
