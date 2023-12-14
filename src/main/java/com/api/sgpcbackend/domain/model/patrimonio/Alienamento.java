package com.api.sgpcbackend.domain.model.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.AlienamentoCadastroDTO;
import com.api.sgpcbackend.domain.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "alienamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Alienamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patrimonio")
    @NotNull()
    private Patrimonio patrimonio;

    @ManyToOne
    @JoinColumn(name = "usuario")
    @NotNull()
    private Usuario usuario;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data_alienamento")
    @NotNull()
    private LocalDate data;

    public Alienamento(AlienamentoCadastroDTO dto)
    {
        Patrimonio patrimonio = new Patrimonio();
        Usuario usuario = new Usuario();

        patrimonio.setId(dto.patrimonio());
        usuario.setId(dto.usuario());

        setPatrimonio(patrimonio);
        setUsuario(usuario);

        setData(dto.data());
    }
}
