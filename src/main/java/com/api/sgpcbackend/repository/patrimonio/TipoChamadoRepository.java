package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.chamado.TipoChamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoChamadoRepository extends JpaRepository<TipoChamado, Short> {
}
