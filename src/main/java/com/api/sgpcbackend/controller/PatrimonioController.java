package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.patrimonio.*;
import com.api.sgpcbackend.domain.model.chamado.Chamado;
import com.api.sgpcbackend.domain.model.chamado.EstadoChamado;
import com.api.sgpcbackend.domain.model.chamado.TipoChamado;
import com.api.sgpcbackend.domain.model.patrimonio.Alienamento;
import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import com.api.sgpcbackend.domain.model.patrimonio.Manejo;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.model.patrimonio.localidade.Comodo;
import com.api.sgpcbackend.domain.roles.EstadoPatrimonio;
import com.api.sgpcbackend.domain.roles.TipoPatrimonio;
import com.api.sgpcbackend.repository.ChamadoRepository;
import com.api.sgpcbackend.repository.patrimonio.*;
import com.api.sgpcbackend.repository.patrimonio.AlienamentoListarDTORepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioController
{
    @Autowired
    private PatrimonioRepository repository;

    @Autowired
    private ManejoRepository manejoRepository;

    @Autowired
    private AlienamentoListarDTORepository  alienamentoListarDTORepository;

    @Autowired
    private AlienamentoRepository alienamentoRepository;

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



    //private Logger logger = LoggerFactory.getLogger(PatrimonioController.class);

//    @PutMapping("/atualizar")
//    @Transactional
//    public ResponseEntity<String> atualizssar(@RequestBody @Valid PatrimonioCadastroDTO dto)
//    {
//        Patrimonio patrimonio = repository.getReferenceById(dto.id());
//
//        patrimonio.atualizar(dto);
//
//
//        return new ResponseEntity<>("Dados do patrimônio alterados com sucesso", HttpStatus.ACCEPTED);
//    }

    @PutMapping("/manejar")
    @Transactional
    public ResponseEntity<String> manejar(@RequestBody @Valid ManejoCadastroDTO dto){

        Patrimonio patrimonio = repository.getReferenceById(dto.patrimonio());

        patrimonio.setLocalidade(new Comodo(dto.comodo_posterior()));

        _manejar(dto);

        return new ResponseEntity<>("Manejo feito com sucesso", HttpStatus.CREATED);
    }

    @PostMapping
    private void _manejar(@RequestBody ManejoCadastroDTO dto){
        Manejo manejo = new Manejo(dto);
        manejoRepository.save(manejo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PatrimonioListarDTO>> listar()
    {
        return ResponseEntity.ok(dtoRepository.findAll());
    }

    @GetMapping("/listarr")
    public ResponseEntity<List<Patrimonio>> listarr()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/alienar/listar")
    public ResponseEntity<List<AlienamentoListarDTO>> listarAlienamentos()
    {
        return ResponseEntity.ok(alienamentoListarDTORepository.findAll());
    }
    @GetMapping("/get_patrimonio")
    public ResponseEntity<Optional<Patrimonio>> getPatrimonio(@RequestParam @Valid UUID id){

        Optional<Patrimonio> optionalPatrimonio = repository.getPatrimonioById(id);

       // return ResponseEntity.ok("DEU CERTO " + patrimonio.getTombamento());
        if(optionalPatrimonio.isEmpty()){
            return ResponseEntity.ofNullable(optionalPatrimonio);
        }
        return ResponseEntity.ok(optionalPatrimonio);

        //return  ResponseEntity.ok(repository.getReferenceById(id));
    }

    @GetMapping("/listar_por_complexo")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorComplexo(@RequestParam String complexo)
    {
        return ResponseEntity.ok(dtoRepository.findAllByComplexo(complexo));
    }

    @GetMapping("/listar_por_predio")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorPredio(@RequestParam String complexo,@RequestParam String predio)
    {
        return ResponseEntity.ok(dtoRepository.findAllByComplexoAndPredio(complexo,predio));
    }

    @GetMapping("/listar_por_andar")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorAndar(@RequestParam String complexo, @RequestParam String predio,@RequestParam String andar)
    {
        return ResponseEntity.ok(dtoRepository.findAllByComplexoAndPredioAndAndar(complexo,predio,andar));
    }

    @GetMapping("/listar_por_comodo")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorComodo(@RequestParam String complexo,@RequestParam String predio,@RequestParam String andar, @RequestParam String comodo)
    {
        return ResponseEntity.ok(dtoRepository.findAllByComplexoAndPredioAndAndarAndComodo(complexo, predio, andar, comodo));
    }
    @GetMapping("/listar_por_tipo")
    public ResponseEntity<List<PatrimonioListarDTO>> listarPorTipo(@RequestParam String tipo)
    {
        return ResponseEntity.ok(dtoRepository.findAllByTipo(tipo));
    }

    @GetMapping("/computador/listar")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputador()
    {
        return ResponseEntity.ok(computadorDTORepository.findAll());
    }

    @GetMapping("/computador/listar_por_complexo")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputadorPorComplexo(@RequestParam String complexo)
    {
        return ResponseEntity.ok(computadorDTORepository.findAllByComplexo(complexo));
    }

    @GetMapping("/computador/listar_por_predio")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputadorPorPredio(@RequestParam String predio)
    {
        return ResponseEntity.ok(computadorDTORepository.findAllByPredio(predio));
    }

    @GetMapping("/computador/listar_por_andar")
    public ResponseEntity<List<ComputadorListarDTO>> listarComputadorPorAndar(@RequestParam String predio,@RequestParam String andar)
    {
        return ResponseEntity.ok(computadorDTORepository.findAllByPredioAndAndar(predio,andar));
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

    @PutMapping("/alienar")
    @Transactional
    public ResponseEntity<String> alienar(@RequestBody @Valid AlienamentoCadastroDTO dto)
    {
        Patrimonio patrimonio = repository.getReferenceById(dto.patrimonio());
        Alienamento alienamento = new Alienamento(dto);
        patrimonio.setAlienado(true);
        alienamentoRepository.save(alienamento);

        return new ResponseEntity<>("Patrimônio alienado com sucesso", HttpStatus.ACCEPTED);
    }



    @PutMapping("/computador/atualizar")
    @Transactional
    public ResponseEntity<String> atualizarComputador(@RequestBody @Valid ComputadorCadastroDTO dto)
    {
        Computador computador = computadorRepository.getReferenceById(dto.id());

        computador.atualizar(dto);

        return new ResponseEntity<>("Dados do patrimônio (computador) alterados com sucesso", HttpStatus.ACCEPTED);
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
