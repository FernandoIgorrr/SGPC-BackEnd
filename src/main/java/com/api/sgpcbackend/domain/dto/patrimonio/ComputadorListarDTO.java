package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "computadores_completo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ComputadorListarDTO extends PatrimonioListarDTO
{

    @Column(name = "serialpc", unique = true)
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
}
