package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hd_pc")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class HD
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public HD(Short id)
    {
        this.id = id;
    }
}
