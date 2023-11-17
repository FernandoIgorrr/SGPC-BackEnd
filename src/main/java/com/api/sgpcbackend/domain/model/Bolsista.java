package com.api.sgpcbackend.domain.model;


import com.api.sgpcbackend.domain.dto.BolsistaCadastroDTO;
import com.api.sgpcbackend.domain.dto.SupervisorCadastroDTO;
import com.api.sgpcbackend.domain.roles.TipoBolsista;
import com.api.sgpcbackend.domain.roles.TipoSupervisor;
import com.api.sgpcbackend.domain.roles.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Data
@Table(name = "bolsista")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "2")
public class Bolsista extends Usuario
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "tipo_bolsista")
    private TipoBolsista tipo_bolsista;

    public Bolsista(BolsistaCadastroDTO dto)
    {
        login           = dto.login();
        matricula       = dto.matricula();
        nome            = dto.nome();
        email           = dto.email();
        telefone        = dto.telefone();
        atvio           = true;
        //tipo_usuario    = new TipoUsuario((short)2);
        data_chegada    = dto.data_chegada();

        tipo_bolsista = new TipoBolsista(dto.tipo_bolsista());
    }
}
