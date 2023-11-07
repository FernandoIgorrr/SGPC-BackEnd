package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "patrimonio_pc")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "2205")
public class Computador extends Patrimonio
{
    private static final long serialVersionUID = 1L;

    @Column(name = "serialpc", unique = true)
    private String serial;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "os")
    private SistemaOperacional sistema_operacional;

    @ManyToOne
    @JoinColumn(name = "ram")
    private Ram ram;

    @ManyToOne
    @JoinColumn(name = "ram_ddr")
    private RamDDR ram_ddr;

    @ManyToOne
    @JoinColumn(name = "hd")
    private HD hd;
}
