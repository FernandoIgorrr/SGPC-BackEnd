package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ram_pc")
@NoArgsConstructor
public class Ram
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public Ram(Integer id)
    {
        this.id = id;
    }
}
