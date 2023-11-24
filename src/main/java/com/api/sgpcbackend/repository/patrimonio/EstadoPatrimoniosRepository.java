package com.api.sgpcbackend.repository.patrimonio;

import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPatrimoniosRepository extends JpaRepository<EstadoPatrimonio, Short> {
}
