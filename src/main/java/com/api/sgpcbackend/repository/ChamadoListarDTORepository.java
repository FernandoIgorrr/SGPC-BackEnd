package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.dto.chamado.ChamadoListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoListarDTORepository extends JpaRepository<ChamadoListarDTO,Integer> {
    List<ChamadoListarDTO> findAllByEstado(String estado);
}
