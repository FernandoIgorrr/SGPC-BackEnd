package com.api.sgpcbackend.domain.model.patrimonio.computador.espec;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "os_pc")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SistemaOperacional
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public SistemaOperacional(Short id)
    {
        this.id = id;
    }
}
