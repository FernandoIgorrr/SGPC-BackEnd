package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorListarDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.repository.ComputadorListarDTORepository;
import com.api.sgpcbackend.repository.ComputadorRepository;
import com.api.sgpcbackend.repository.PatrimonioListarDTORepository;
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
    private PatrimonioListarDTORepository dtoRepository;

    @Autowired
    private ComputadorRepository computadorRepository;

    @Autowired
    private ComputadorListarDTORepository computadorDTORepository;

    private Logger logger = LoggerFactory.getLogger(PatrimonioController.class);

    @GetMapping("/exemplo")
    public ResponseEntity<Patrimonio> getExemplo() {
        Patrimonio model = new Patrimonio();
        // Popule o modelo aqui
        logger.info("JSON do objeto model: " + model);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PatrimonioListarDTO>> listar()
    {

        return ResponseEntity.ok(dtoRepository.findAll());
    }

    @GetMapping("/computador/listar")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputador()
    {
        return ResponseEntity.ok(computadorDTORepository.findAll());
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

    @PostMapping("/cadastrar_lista")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid List<PatrimonioCadastroDTO> dtos)
    {
        for (PatrimonioCadastroDTO dto: dtos)
        {
            try {
                Patrimonio patrimonio = new Patrimonio(dto);

                if (repository.existsAllByTombamento(patrimonio.getTombamento()))
                    continue;
                repository.save(patrimonio);
            }catch (Exception ignored)
            {}
        }

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

    @PostMapping("/computador/cadastrar_lista")
    public ResponseEntity<String> cadastrar_pc(@RequestBody @Valid List<ComputadorCadastroDTO> dtos)
    {
        for (ComputadorCadastroDTO dto: dtos)
        {
            try {
                Computador computador = new Computador(dto);

                if (repository.existsAllByTombamento(computador.getTombamento()))
                    continue;
                if (computadorRepository.existsAllBySerial(computador.getSerial()))
                    continue;
                computadorRepository.save(computador);
            }catch (Exception ignored)
            {}
        }
        System.out.println("TAMANHO DA LISTA NO FINAL: " + dtos.size());
        return new ResponseEntity<>("Computadores cadastrados com sucesso", HttpStatus.CREATED);
    }
}
