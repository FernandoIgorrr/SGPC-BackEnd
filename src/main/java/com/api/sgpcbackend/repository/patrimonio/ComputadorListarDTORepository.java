package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorListarDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ComputadorListarDTORepository extends JpaRepository<ComputadorListarDTO, UUID>
{
    List<ComputadorListarDTO> findAllByComplexo(String complexo);
    List<ComputadorListarDTO> findAllByPredio(String predio);
    List<ComputadorListarDTO> findAllByPredioAndAndar(String predio,String andar);
}
