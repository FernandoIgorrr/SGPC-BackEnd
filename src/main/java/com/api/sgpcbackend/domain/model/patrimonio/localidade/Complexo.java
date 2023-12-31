package com.api.sgpcbackend.domain.model.patrimonio.localidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "complexo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complexo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "nome")
    private String nome;

    public Complexo(Short id){
        this.id = id;
    }
}
