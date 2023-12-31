package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatrimonioRepository extends JpaRepository<Patrimonio, UUID>
{
    public boolean existsAllByTombamento(String tombamento);

    public Optional<Patrimonio> getPatrimonioById(UUID id);


}
