package com.api.sgpcbackend.domain.dto.chamado;

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
@Table(name = "chamados_completo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoListarDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "criador")
    private String criador;

    @Column(name = "fechador")
    private String fechador;

    @Column(name = "data_abertura")
    private LocalDate data_abertura;

    @Column(name = "data_fechamento")
    private LocalDate data_fechamento;

    @Column(name = "complexo")
    private String complexo;

    @Column(name = "predio")
    private String predio;

    @Column(name = "andar")
    private String andar;

    @Column(name = "comodo")
    private String comodo;
}
