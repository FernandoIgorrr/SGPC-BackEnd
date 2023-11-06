package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.AutenticacaoDTO;
import com.api.sgpcbackend.domain.dto.LoginResponseDTO;
import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutentitacacaoController
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO dados)
    {
        var userNamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth             = authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
