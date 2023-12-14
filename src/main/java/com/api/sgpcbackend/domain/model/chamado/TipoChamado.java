package com.api.sgpcbackend.domain.model.chamado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tipo_chamado")
@NoArgsConstructor
@AllArgsConstructor
public class TipoChamado
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public TipoChamado(Short id)
    {
        this.id = id;
    }
}
