package com.api.sgpcbackend.repository;

import com.api.sgpcbackend.model.TabelaBase.NivelAcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelAcessoRepository extends JpaRepository<NivelAcessoModel, Short>
{

}
