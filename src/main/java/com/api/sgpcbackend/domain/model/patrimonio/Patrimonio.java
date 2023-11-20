package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Table(name = "patrimonio")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER)
@AllArgsConstructor
@NoArgsConstructor
public class Patrimonio implements Serializable
{
    @Serial
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

    @ManyToOne
    @JoinColumn(name = "estado")
    protected EstadoPatrimonio estado;

    @ManyToOne
    @JoinColumn(name = "tipo")
    protected TipoPatrimonio tipo_patrimonio;

    @ManyToOne
    @JoinColumn(name = "localidade")
    protected Comodo localidade;


    @Column(name = "alienado")
    protected Boolean alienado;

    public Patrimonio(PatrimonioCadastroDTO dto)
    {
        tombamento      = dto.tombamento();
        descricao       = dto.descricao();
        estado          = new EstadoPatrimonio(dto.estado());
        tipo_patrimonio = new TipoPatrimonio(dto.tipo());
        localidade      = new Comodo(dto.localidade());
        alienado        = false;
    }

    public void atualizar(PatrimonioCadastroDTO dto)
    {
        setTombamento(dto.tombamento());
        setDescricao(dto.descricao());
        setEstado(new EstadoPatrimonio(dto.estado()));
        setTipo_patrimonio(new TipoPatrimonio(dto.tipo()));
        setAlienado(dto.alienado());
    }
}
