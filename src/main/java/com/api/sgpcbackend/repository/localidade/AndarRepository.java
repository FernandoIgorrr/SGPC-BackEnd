package com.api.sgpcbackend.repository.localidade;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Andar;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AndarRepository extends JpaRepository<Andar,Short> {
    List<Andar> findAllByPredio(Predio predio);
}
