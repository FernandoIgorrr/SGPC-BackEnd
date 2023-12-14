package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.chamado.ChamadoAlterarDTO;
import com.api.sgpcbackend.domain.dto.chamado.ChamadoCadastrarDTO;
import com.api.sgpcbackend.domain.dto.chamado.ChamadoFechaDTO;
import com.api.sgpcbackend.domain.dto.chamado.ChamadoListarDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.AlienamentoCadastroDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioListarDTO;
import com.api.sgpcbackend.domain.model.chamado.Chamado;
import com.api.sgpcbackend.domain.model.chamado.EstadoChamado;
import com.api.sgpcbackend.domain.model.chamado.TipoChamado;
import com.api.sgpcbackend.domain.model.patrimonio.Alienamento;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.repository.ChamadoListarDTORepository;
import com.api.sgpcbackend.repository.ChamadoRepository;
import com.api.sgpcbackend.repository.patrimonio.EstadoChamadoRepository;
import com.api.sgpcbackend.repository.patrimonio.TipoChamadoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private ChamadoListarDTORepository chamadoListarDTORepository;

    @Autowired
    private EstadoChamadoRepository estadoChamadoRepository;

    @Autowired
    private TipoChamadoRepository tipoChamadoRepository;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrarChamado(@RequestBody @Valid ChamadoCadastrarDTO dto){
        Chamado chamado = new Chamado(dto);
        repository.save(chamado);

        return new ResponseEntity<>("Chamado cadastrado com sucesso", HttpStatus.CREATED);
    }
    @PutMapping("/alterar")
    @Transactional
    public ResponseEntity<String> alterar(@RequestBody @Valid ChamadoAlterarDTO dto)
    {
        Chamado chamado = repository.getReferenceById(dto.id());

        chamado.atualiza(dto);

        return new ResponseEntity<>("Chamado atualizado com sucesso", HttpStatus.ACCEPTED);
    }

    @PutMapping("/fechar")
    @Transactional
    public ResponseEntity<String> fechar(@RequestBody @Valid ChamadoFechaDTO dto)
    {
       Chamado chamado = repository.getReferenceById(dto.id());

        chamado.fecha(dto);

        return new ResponseEntity<>("Chamado fechado com sucesso", HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar")
    public List<ChamadoListarDTO> listar(){
        return chamadoListarDTORepository.findAll();
    }
    @GetMapping("/listar_por_estado")
    public ResponseEntity<List<ChamadoListarDTO>> listarPorEstado(@RequestParam String estado)
    {
        return ResponseEntity.ok(chamadoListarDTORepository.findAllByEstado(estado));
    }

    @GetMapping("/estado/listar")
    public ResponseEntity<List<EstadoChamado>> estadosChamado()
    {
        return ResponseEntity.ok(estadoChamadoRepository.findAll());
    }
    @GetMapping("/tipo/listar")
    public ResponseEntity<List<TipoChamado>> tiposChamado() {
        return ResponseEntity.ok(tipoChamadoRepository.findAll());
    }
}
