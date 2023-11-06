package com.api.sgpcbackend.domain.model;


import com.api.sgpcbackend.domain.roles.TipoBolsista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "bolsista")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "BOLSISTA")
public class Bolsista extends Usuario
{
    private static final long serialVersionUID = 1L;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "tipo_bolsista")
    @Enumerated(EnumType.STRING)
    private TipoBolsista tipo_bolsista;
}
