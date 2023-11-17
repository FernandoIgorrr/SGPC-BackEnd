package com.api.sgpcbackend.domain.model;

import com.api.sgpcbackend.domain.dto.SupervisorCadastroDTO;
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
@Table(name = "supervisor")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "1")
public class Supervisor extends Usuario
{
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tipo_supervisor")
    private TipoSupervisor tipo_supervisor;

    public Supervisor(SupervisorCadastroDTO dto)
    {
        login           = dto.login();
        nome            = dto.nome();
        email           = dto.email();
        telefone        = dto.telefone();
        atvio           = true;
        //tipo_usuario    = new TipoUsuario((short)1);
        data_chegada    = dto.data_chegada();

        tipo_supervisor = new TipoSupervisor(dto.tipo_supervisor());
    }
}
