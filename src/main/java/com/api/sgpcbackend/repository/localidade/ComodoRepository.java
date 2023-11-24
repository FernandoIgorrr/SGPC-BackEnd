package com.api.sgpcbackend.repository.localidade;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Andar;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComodoRepository extends JpaRepository<Comodo,Short> {
    List<Comodo> findAllByAndar(Andar andar);

}
