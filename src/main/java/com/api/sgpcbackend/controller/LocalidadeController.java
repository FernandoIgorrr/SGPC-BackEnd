package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.model.patrimonio.localidade.Andar;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Complexo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Predio;
import com.api.sgpcbackend.repository.localidade.AndarRepository;
import com.api.sgpcbackend.repository.localidade.ComodoRepository;
import com.api.sgpcbackend.repository.localidade.ComplexoRepository;
import com.api.sgpcbackend.repository.localidade.PredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/localidade")
public class LocalidadeController {

    @Autowired
    private ComplexoRepository complexoRepository;

    @Autowired
    private PredioRepository predioRepository;

    @Autowired
    private AndarRepository andarRepository;

    @Autowired
    private ComodoRepository comodoRepository;

    @GetMapping("/complexo/listar")
    ResponseEntity<List<Complexo>> listarComplexos()
    {
        return ResponseEntity.ok(complexoRepository.findAll());
    }

    @GetMapping("/predio/listar")
    ResponseEntity<List<Predio>> listarPredios(@RequestParam Short complexo)
    {
        return ResponseEntity.ok(predioRepository.findAllByComplexo(new Complexo(complexo)));
    }

    @GetMapping("/andar/listar")
    ResponseEntity<List<Andar>> listarAndares(@RequestParam Short predio)
    {
        return ResponseEntity.ok(andarRepository.findAllByPredio(new Predio(predio)));
    }

    @GetMapping("/comodo/listar")
    ResponseEntity<List<Comodo>> listarComodos(@RequestParam Short andar)
    {
        return ResponseEntity.ok(comodoRepository.findAllByAndar(new Andar(andar)));
    }
}
