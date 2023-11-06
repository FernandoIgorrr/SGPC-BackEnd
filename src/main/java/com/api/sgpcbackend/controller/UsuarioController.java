package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController
{
    private  final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }

//    @GetMapping("/validar_senha")
//    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String senha)
//    {
//        Optional<Usuario> optionalUsuario = repository.findByLogin(login);
//
//        if(optionalUsuario.isEmpty())
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//
//        boolean valido = encoder.matches(senha,optionalUsuario.get().getSenha());
//
//        HttpStatus status = (valido) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//
//        return ResponseEntity.status(status).body(valido);
//    }
}
