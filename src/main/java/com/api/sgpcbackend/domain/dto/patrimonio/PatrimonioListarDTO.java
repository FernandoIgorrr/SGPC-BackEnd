package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.UUID;

@Data
@Table(name = "patrimonios_completo")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioListarDTO
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "tombamento", unique = true)
    private String tombamento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

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
