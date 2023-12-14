package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Data
@Table(name = "patrimonio_pc")
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
public class Computador extends Patrimonio
{
    @Serial
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
    private RAM ram;

    @ManyToOne
    @JoinColumn(name = "ram_ddr")
    private RAMDDR ram_ddr;

    @ManyToOne
    @JoinColumn(name = "hd")
    private HD hd;

    public Computador(ComputadorCadastroDTO dto)
    {
        tombamento          = dto.tombamento();
        descricao           = dto.descricao();
        estado              = new EstadoPatrimonio(dto.estado());
        tipo_patrimonio     = new TipoPatrimonio((short)2205);
        localidade          = new Comodo(dto.localidade());
        alienado            = false;

        //----------------------------------------------------------------------

        serial              = dto.serial();
        modelo              = new Modelo(dto.modelo());
        sistema_operacional = new SistemaOperacional(dto.sistema_operacional());
        ram                 = new RAM(dto.ram());
        ram_ddr             = new RAMDDR(dto.ram_ddr());
        hd                  = new HD(dto.hd());
    }

    public void atualizar(ComputadorCadastroDTO dto)
    {
        setTombamento(dto.tombamento());
        setDescricao(dto.descricao());
        setEstado(new EstadoPatrimonio(dto.estado()));
        //setAlienado(dto.alienado());

        //----------------------------------------------------------------------

        setSerial(dto.serial());
        setModelo(new Modelo(dto.modelo()));
        setSistema_operacional(new SistemaOperacional(dto.sistema_operacional()));
        setRam(new RAM(dto.ram()));
        setRam_ddr(new RAMDDR(dto.ram_ddr()));
        setHd(new HD(dto.hd()));
    }
}
