package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.repository.ComputadorRepository;
import com.api.sgpcbackend.repository.PatrimonioRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController
{
    @Autowired
    private PatrimonioRepository repository;

    @Autowired
    private ComputadorRepository computadorRepository;

    private Logger logger = LoggerFactory.getLogger(PatrimonioController.class);

    @GetMapping("/exemplo")
    public ResponseEntity<Patrimonio> getExemplo() {
        Patrimonio model = new Patrimonio();
        // Popule o modelo aqui
        logger.info("JSON do objeto model: " + model);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Patrimonio>> listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid PatrimonioCadastroDTO dto)
    {
        Patrimonio patrimonio = new Patrimonio(dto);

        if(repository.existsAllByTombamento(patrimonio.getTombamento()))
            return new ResponseEntity<>("Tombamento já cadastrado", HttpStatus.CONFLICT);

        repository.save(patrimonio);
        return new ResponseEntity<>("Patrimônio cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/computador/cadastrar")
    public ResponseEntity<String> cadastrar_pc(@RequestBody @Valid ComputadorCadastroDTO dto)
    {
        Computador computador = new Computador(dto);

        if(repository.existsAllByTombamento(computador.getTombamento()))
            return new ResponseEntity<>("Tombamento já cadastrado", HttpStatus.CONFLICT);
        if(computadorRepository.existsAllBySerial(computador.getSerial()))
            return new ResponseEntity<>("Serial já cadastrado", HttpStatus.CONFLICT);

        computadorRepository.save(computador);

        return new ResponseEntity<>("Computador cadastrado com sucesso", HttpStatus.CREATED);
    }
}
