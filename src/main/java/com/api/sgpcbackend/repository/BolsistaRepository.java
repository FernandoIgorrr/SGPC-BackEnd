package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.model.Bolsista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BolsistaRepository extends JpaRepository<Bolsista, UUID>
{
    public boolean existsAllByMatricula(String matricula);
    public boolean existsAllByEmail(String email);
    public boolean existsAllByLogin(String login);
}
