package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorListarDTORepository extends JpaRepository<ComputadorListarDTO, UUID>
{

}
