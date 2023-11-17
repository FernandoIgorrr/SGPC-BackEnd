package com.api.sgpcbackend.domain.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tipo_supervisor")
@NoArgsConstructor
@AllArgsConstructor
public class TipoSupervisor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "descricao")
    private String descricao;

    public TipoSupervisor(Short id)
    {
        this.id = id;
    }
}
