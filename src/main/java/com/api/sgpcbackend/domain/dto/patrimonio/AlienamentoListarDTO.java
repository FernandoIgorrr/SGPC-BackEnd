package com.api.sgpcbackend.domain.dto.patrimonio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Data
@Table(name = "alienamentos_completo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AlienamentoListarDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tombamento")
    private String tombamento;

    @Column(name = "tipo")
    private String tipo;


    @Column(name = "nome")
    private String nome;

    @Column(name = "data")
    private LocalDate data;
}
