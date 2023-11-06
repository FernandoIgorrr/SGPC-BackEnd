package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupervisorRepository extends JpaRepository<Supervisor, UUID>
{
    public boolean existsAllByEmail(String email);
    public boolean existsAllByLogin(String login);
}
