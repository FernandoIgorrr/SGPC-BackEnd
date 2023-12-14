package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>
{
    public UserDetails findByLogin(String login);
    public Optional<Usuario> findUsuarioByLogin(String login);

}
