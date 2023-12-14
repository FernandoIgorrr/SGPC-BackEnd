package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.model.patrimonio.Manejo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManejoRepository extends JpaRepository<Manejo, UUID> {
}
