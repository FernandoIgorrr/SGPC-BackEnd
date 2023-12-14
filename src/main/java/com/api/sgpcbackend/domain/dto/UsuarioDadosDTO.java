package com.api.sgpcbackend.domain.dto;

import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.domain.roles.TipoUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UsuarioDadosDTO {

    UUID id;
    String login;

    TipoUsuario tipoUsuario;

    public UsuarioDadosDTO(Usuario usuario){
        setId(usuario.getId());
        setLogin(usuario.getLogin());
        setTipoUsuario(usuario.getTipo_usuario());
    }

}
