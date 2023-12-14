package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.chamado.EstadoChamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoChamadoRepository extends JpaRepository<EstadoChamado,Short> {
}
