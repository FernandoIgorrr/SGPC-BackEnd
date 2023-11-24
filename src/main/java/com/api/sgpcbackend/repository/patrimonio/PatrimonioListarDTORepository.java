package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatrimonioListarDTORepository extends JpaRepository<PatrimonioListarDTO, UUID>
{

}
