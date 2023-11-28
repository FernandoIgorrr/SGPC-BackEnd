package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.model.patrimonio.computador.espec.*;
import com.api.sgpcbackend.repository.especs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pc_specs")
public class PCSpecController {
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private SistemaOperacionalRepository sistemaOperacionalRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private RAMDDRRepository ramddrRepository;

    @Autowired
    private HDRepository hdRepository;

    @GetMapping("/modelo/listar")
    ResponseEntity<List<Modelo>> listarModelos()
    {
        return ResponseEntity.ok(modeloRepository.findAll());
    }

    @GetMapping("/sistema_operacional/listar")
    ResponseEntity<List<SistemaOperacional>> listarSistemasOperacionais()
    {
        return ResponseEntity.ok(sistemaOperacionalRepository.findAll());
    }

    @GetMapping("/ram/listar")
    ResponseEntity<List<RAM>> listarRAMs()
    {
        return ResponseEntity.ok(ramRepository.findAll());
    }

    @GetMapping("/ram_ddr/listar")
    ResponseEntity<List<RAMDDR>> listarRAMDDRs()
    {
        return ResponseEntity.ok(ramddrRepository.findAll());
    }

    @GetMapping("/hd/listar")
    ResponseEntity<List<HD>> listarHDs()
    {
        return ResponseEntity.ok(hdRepository.findAll());
    }


}
