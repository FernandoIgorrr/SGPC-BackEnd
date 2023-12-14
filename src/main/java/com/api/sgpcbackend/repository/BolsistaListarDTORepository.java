package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.dto.BolsistaListarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BolsistaListarDTORepository extends JpaRepository<BolsistaListarDTO, UUID> {

}
