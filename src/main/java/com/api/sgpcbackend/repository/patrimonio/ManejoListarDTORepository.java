package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.dto.patrimonio.ManejoListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManejoListarDTORepository extends JpaRepository<ManejoListarDTO, Long> {
}
