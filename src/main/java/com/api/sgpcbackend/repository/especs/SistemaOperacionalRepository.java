package com.api.sgpcbackend.repository.especs;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.SistemaOperacional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SistemaOperacionalRepository extends JpaRepository<SistemaOperacional,Short> {
}
