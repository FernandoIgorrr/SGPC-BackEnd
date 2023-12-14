package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.AlienamentoListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienamentoListarDTORepository extends JpaRepository<AlienamentoListarDTO, Integer> {
}
