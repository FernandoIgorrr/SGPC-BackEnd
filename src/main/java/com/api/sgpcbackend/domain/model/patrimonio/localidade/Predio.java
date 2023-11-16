package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "predio")
@Data
@NoArgsConstructor

@AllArgsConstructor
public class Predio
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "complexo")
    private Complexo complexo;
}
