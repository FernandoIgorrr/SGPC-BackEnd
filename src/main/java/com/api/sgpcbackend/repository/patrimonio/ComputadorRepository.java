package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorRepository extends JpaRepository<Computador, UUID>
{
    public boolean existsAllBySerial(String serial);
}
