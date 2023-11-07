package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;

@Entity
@Table(name = "ram_ddr_pc")
public class RamDDR
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;
}
