package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "computadores_completo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ComputadorListarDTO
{
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "tombamento", unique = true)
    private String tombamento;

    @Column(name = "serial", unique = true)
    private String serial;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "os")
    private String sistema_operacional;

    @Column(name = "ram")
    private String ram;

    @Column(name = "ddr")
    private String ram_ddr;

    @Column(name = "hd")
    private String hd;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "estado")
    private String estado;

    @Column(name = "alienado")
    private Boolean alienado;

    @Column(name = "comodo")
    private String comodo;

    @Column(name = "andar")
    private String andar;

    @Column(name = "predio")
    private String predio;

    @Column(name = "complexo")
    private String complexo;
}
