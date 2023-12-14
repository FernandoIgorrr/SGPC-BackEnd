package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.model.chamado.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {

}
