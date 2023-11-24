package com.api.sgpcbackend.repository.localidade;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Andar;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Complexo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredioRepository extends JpaRepository<Predio,Short> {
    List<Predio> findAllByComplexo(Complexo complexo);

}
