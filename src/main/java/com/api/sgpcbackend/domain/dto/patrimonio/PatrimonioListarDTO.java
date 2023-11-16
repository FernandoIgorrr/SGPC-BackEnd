package com.api.sgpcbackend.domain.dto.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table(name = "patrimonios_completo")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioListarDTO
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    protected UUID id;

    @NotNull(message = "É necessário preencher o campo tombamento")
    @Column(name = "tombamento", unique = true)
    protected String tombamento;

    @Column(name = "descricao")
    protected String descricao;

    @Column(name = "estado")
    protected String estado;

    @Column(name = "tipo")
    protected String tipo;

    @Column(name = "alienado")
    protected Boolean alienado;

    @Column(name = "comodo")
    protected String comodo;

    @Column(name = "andar")
    protected String andar;

    @Column(name = "predio")
    protected String predio;

    @Column(name = "complexo")
    protected String complexo;
}
