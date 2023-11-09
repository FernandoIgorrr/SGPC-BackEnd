package com.api.sgpcbackend.domain.model.patrimonio;

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
@Table(name = "historico_manejo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoManejo
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
    @JoinColumn(name = "comodo")
    @NotNull()
    private Comodo localidade;

    @ManyToOne
    @JoinColumn(name = "usuario")
    @NotNull()
    private Usuario usuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_chegada")
    @NotNull()
    private LocalDate data_chegada;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_saida")
    private LocalDate data_saida;
}
