package com.api.sgpcbackend.repository.especs;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo,Short> {
}
