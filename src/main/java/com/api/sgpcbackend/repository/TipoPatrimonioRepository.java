package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPatrimonioRepository extends JpaRepository<TipoPatrimonio,Short> {
}
