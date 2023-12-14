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
@Table(name = "manejos_completo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ManejoListarDTO {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tombamento")
    private String tombamento;


    @Column(name = "tipo")
    private String tipo;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "nome")
    private String nome;

    @Column(name = "complexo_anterior")
    private String complexo_anterior;

    @Column(name = "predio_anterior")
    private String predio_anterior;

    @Column(name = "andar_anterior")
    private String andar_anterior;

    @Column(name = "comodo_anterior")
    private String comodo_anterior;

    @Column(name = "complexo_posterior")
    private String complexo_posterior;

    @Column(name = "predio_posterior")
    private String predio_posterior;

    @Column(name = "andar_posterior")
    private String andar_posterior;

    @Column(name = "comodo_posterior")
    private String comodo_posterior;

}
