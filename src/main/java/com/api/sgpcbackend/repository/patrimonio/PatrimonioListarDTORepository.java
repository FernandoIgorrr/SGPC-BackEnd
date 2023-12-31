package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatrimonioListarDTORepository extends JpaRepository<PatrimonioListarDTO, UUID>
{
    List<PatrimonioListarDTO> findAllByComplexo(String complexo);
    List<PatrimonioListarDTO> findAllByComplexoAndPredio(String complexo, String predio);
    List<PatrimonioListarDTO> findAllByComplexoAndPredioAndAndar(String complexo,String predio,String andar);
    List<PatrimonioListarDTO> findAllByComplexoAndPredioAndAndarAndComodo(String complexo, String predio, String andar, String comodo);
    List<PatrimonioListarDTO> findAllByTipo(String tipo);
}
