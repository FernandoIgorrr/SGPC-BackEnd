package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.patrimonio.ManejoListarDTO;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.repository.patrimonio.ManejoListarDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manejo")
public class ManejoController
{
    @Autowired
    private ManejoListarDTORepository manejoListarDTORepository;

    @GetMapping("/listar")
    public ResponseEntity<List<ManejoListarDTO>> listar()
    {
        return ResponseEntity.ok(manejoListarDTORepository.findAll());
    }
}
