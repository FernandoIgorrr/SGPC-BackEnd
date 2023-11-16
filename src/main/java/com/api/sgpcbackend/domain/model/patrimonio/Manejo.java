package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.model.Bolsista;
import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "manejo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manejo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patrimonio")
    @NotNull()
    private Patrimonio patrimonio;

    @ManyToOne
    @JoinColumn(name = "usuario")
    @NotNull()
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comodo_anterior")
    @NotNull()
    private Comodo localidade_anterior;

    @ManyToOne
    @JoinColumn(name = "comodo_posterior")
    @NotNull()
    private Comodo localidade_posterior;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_manejo")
    @NotNull()
    private LocalDate data;
}
