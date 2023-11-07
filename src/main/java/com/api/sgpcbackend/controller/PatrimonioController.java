package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.model.Bolsista;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.model.patrimonio.PatrimonioCadastrarDTO;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
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
    public ResponseEntity<String> cadastrar(@RequestBody @Valid PatrimonioCadastrarDTO dto)
    {
        Patrimonio patrimonio = new Patrimonio();

        patrimonio.setTombamento(dto.getTombamento());
        patrimonio.setDescricao(dto.getDescricao());
        patrimonio.setEstado(new EstadoPatrimonio());


        repository.save(patrimonio);
        return new ResponseEntity<>("Patrimônio cadastrado com sucesso", HttpStatus.CREATED);
    }
}
