package com.api.sgpcbackend.domain.model.chamado;

import com.api.sgpcbackend.domain.dto.chamado.ChamadoAlterarDTO;
import com.api.sgpcbackend.domain.dto.chamado.ChamadoCadastrarDTO;
import com.api.sgpcbackend.domain.dto.chamado.ChamadoFechaDTO;
import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "chamado")
@AllArgsConstructor
@NoArgsConstructor
public class Chamado {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "criador")
    protected Usuario criador;

    @ManyToOne
    @JoinColumn(name = "fechador")
    protected Usuario fechador;

    @Column(name = "data_abertura")
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate data_abertura;

    @Column(name = "data_fechamento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate data_fechamento;

    @Column(name = "titulo")
    String titulo;

    @Column(name = "descricao")
    String descricao;

    @ManyToOne
    @JoinColumn(name = "localidade")
    protected Comodo localidade;

    @ManyToOne
    @JoinColumn(name = "estado")
    protected EstadoChamado estado;

    @ManyToOne
    @JoinColumn(name = "tipo")
    protected TipoChamado tipo;

    public Chamado(ChamadoCadastrarDTO dto){
        Usuario usuario_criador = new Usuario();

        usuario_criador.setId(dto.criador());

        criador = usuario_criador;

        data_abertura = dto.data_abertura();

        titulo = dto.titulo();
        descricao = dto.descricao();
        localidade = new Comodo(dto.localidade());
        estado = new EstadoChamado((short)0);
        tipo = new TipoChamado(dto.tipo());

    }

    public void atualiza(ChamadoAlterarDTO dto){

        setTitulo(dto.titulo());
        setDescricao(dto.descricao());
        setEstado(new EstadoChamado(dto.estado()));
        setTipo(new TipoChamado(dto.tipo()));
    }

    public void fecha(ChamadoFechaDTO dto){
        Usuario usuario = new Usuario();
        usuario.setId(dto.fechador());

        setData_fechamento(dto.data_fechamento());
        setEstado(new EstadoChamado((short)1));
        setFechador(usuario);
    }

}
