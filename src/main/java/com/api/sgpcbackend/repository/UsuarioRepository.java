package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.model.BolsistaModel;
import com.api.sgpcbackend.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long>
{
    public Optional<UsuarioModel> findByLogin(String login);

}
