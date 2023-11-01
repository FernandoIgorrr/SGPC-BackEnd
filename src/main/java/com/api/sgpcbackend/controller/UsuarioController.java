package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.model.UsuarioModel;
import com.api.sgpcbackend.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController
{

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;


    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository         = repository;
        this.encoder            = encoder;
    }

    private ResponseEntity<UsuarioModel> cadastrar(@RequestBody UsuarioModel usuario)
    {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(repository.save(usuario));
    }

    @GetMapping("/validar_senha")
    public ResponseEntity<Boolean> validarSenha(
            @RequestParam String login,
            @RequestParam String senha
    )
    {
        Optional<UsuarioModel> optUsuario = repository.findByLogin(login);
        if(optUsuario.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valido = encoder.matches(senha, optUsuario.get().getSenha());

        HttpStatus status = (valido) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(valido);
    }
}
