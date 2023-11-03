package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.model.BolsistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface BolsistaRepository extends JpaRepository<BolsistaModel, String>
{
    public boolean existsAllByLogin(String login);
    public boolean existsAllByMatricula(String matricula);
    public boolean existsAllByEmail(String email);
}