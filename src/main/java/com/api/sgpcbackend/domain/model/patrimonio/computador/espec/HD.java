package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hd_pc")
@NoArgsConstructor
public class HD
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public HD(Integer id)
    {
        this.id = id;
    }
}
