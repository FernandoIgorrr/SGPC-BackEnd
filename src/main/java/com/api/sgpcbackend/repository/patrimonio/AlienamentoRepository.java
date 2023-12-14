package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.Alienamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienamentoRepository extends JpaRepository<Alienamento,Integer> {
}
