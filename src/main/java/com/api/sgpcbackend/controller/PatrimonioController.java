package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorListarDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Andar;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Complexo;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Predio;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import com.api.sgpcbackend.repository.localidade.AndarRepository;
import com.api.sgpcbackend.repository.localidade.ComodoRepository;
import com.api.sgpcbackend.repository.localidade.ComplexoRepository;
import com.api.sgpcbackend.repository.localidade.PredioRepository;
import com.api.sgpcbackend.repository.patrimonio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private EstadoPatrimoniosRepository estadoPatrimonioRepository;

    @Autowired
    private TipoPatrimonioRepository tipoPatrimonioRepository;

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

    @GetMapping("/listar_por_complexo")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorComplexo(@RequestParam String complexo)
    {
        return ResponseEntity.ok(dtoRepository.findAllByComplexo(complexo));
    }

    @GetMapping("/computador/listar")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputador()
    {
        return ResponseEntity.ok(computadorDTORepository.findAll());
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid PatrimonioCadastroDTO dto)
    {
        Patrimonio patrimonio = new Patrimonio(dto);

        if(repository.existsAllByTombamento(patrimonio.getTombamento()))
            return new ResponseEntity<>("Tombamento já cadastrado", HttpStatus.CONFLICT);

        repository.save(patrimonio);
        return new ResponseEntity<>("Patrimônio cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid PatrimonioCadastroDTO dto)
    {
        Patrimonio patrimonio = repository.getReferenceById(dto.id());

        patrimonio.atualizar(dto);

        return new ResponseEntity<>("Dados do patrimônio alterados com sucesso", HttpStatus.ACCEPTED);
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
    public ResponseEntity<String> cadastrarComputador(@RequestBody @Valid ComputadorCadastroDTO dto)
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
    public ResponseEntity<String> cadastrarComputadores(@RequestBody @Valid List<ComputadorCadastroDTO> dtos)
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
        //System.out.println("TAMANHO DA LISTA NO FINAL: " + dtos.size());
        return new ResponseEntity<>("Computadores cadastrados com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/estado/listar")
    ResponseEntity<List<EstadoPatrimonio>> estadosPatrimonio()
    {
        return ResponseEntity.ok(estadoPatrimonioRepository.findAll());
    }

    @GetMapping("/tipo/listar")
    ResponseEntity<List<TipoPatrimonio>> tiposPatrimonio() {
        return ResponseEntity.ok(tipoPatrimonioRepository.findAll());
    }
}
