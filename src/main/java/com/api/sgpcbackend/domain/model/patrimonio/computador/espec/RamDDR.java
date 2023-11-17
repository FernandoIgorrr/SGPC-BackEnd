package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ram_ddr_pc")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class RamDDR
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public RamDDR(Short id)
    {
        this.id = id;
    }
}
