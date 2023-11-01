package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>
{
    public Optional<UsuarioModel> findByLogin(String login);

//    @Procedure(procedureName = "inserir_bolsista")
//    public UsuarioModel cadastrar_bolsista(
//            @Param("v_matrilcula")      String matricula,
//            @Param("v_id_usuario")      Long id_usuario,
//            @Param("v_tipo_bolsista")   Integer tipo_bolsista);
}
