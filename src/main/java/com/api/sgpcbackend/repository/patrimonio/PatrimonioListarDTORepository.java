package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatrimonioListarDTORepository extends JpaRepository<PatrimonioListarDTO, UUID>
{
    List<PatrimonioListarDTO> findAllByComplexo(String complexo);
    List<PatrimonioListarDTO> findAllByPredio(String predio);
    List<PatrimonioListarDTO> findAllByPredioAndAndar(String predio,String andar);
    List<PatrimonioListarDTO> findAllByComodo(String comodo);
}
