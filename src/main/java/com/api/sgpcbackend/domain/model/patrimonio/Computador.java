package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
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

    public Computador(ComputadorCadastroDTO dto)
    {

        tombamento  = dto.tombamento();
        descricao   = dto.descricao();
        estado      = new EstadoPatrimonio(dto.estado());
        tipo        = new TipoPatrimonio(2205);
        localidade  = new Comodo(dto.localidade());
        alienado    = false;

        //---------------

        serial              = dto.serial();
        modelo              = new Modelo(dto.modelo());
        sistema_operacional = new SistemaOperacional(dto.sistema_operacional());
        ram                 = new Ram(dto.ram());
        ram_ddr             = new RamDDR(dto.ram_ddr());
        hd                  = new HD(dto.hd());
    }
}
