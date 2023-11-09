package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "os_pc")
@NoArgsConstructor
public class SistemaOperacional
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public SistemaOperacional(Integer id)
    {
        this.id = id;
    }
}
