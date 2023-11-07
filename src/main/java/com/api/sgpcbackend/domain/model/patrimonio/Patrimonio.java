package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Table(name = "patrimonio")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER)
@AllArgsConstructor
@NoArgsConstructor
public class Patrimonio implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotNull(message = "É necessário preencher o campo tombamento")
    @Column(name = "tombamento", unique = true)
    private String tombamento;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoPatrimonio estado;

    @ManyToOne
    @JoinColumn(name = "tipo", insertable = false, updatable = false)
    private TipoPatrimonio tipo;

    @ManyToOne
    @JoinColumn(name = "localidade")
    private Comodo localidade;

    @Column(name = "alienado")
    private Boolean alienado;
}
