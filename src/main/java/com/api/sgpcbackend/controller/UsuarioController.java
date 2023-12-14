package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.UsuarioDadosDTO;
import com.api.sgpcbackend.domain.model.Usuario;
import com.api.sgpcbackend.infra.security.ChangePasswordRequest;
import com.api.sgpcbackend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private  final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PutMapping("/alterar_senha")
    @Transactional
    public ResponseEntity<String> alterarSenha(@RequestBody ChangePasswordRequest request){

        Usuario usuario = repository.getReferenceById(request.id());

        boolean valido = encoder.matches(request.senha_antiga(),usuario.getSenha());

        HttpStatus status = (valido) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        String response = (valido) ? "Senha alterada com sucesso" : "A senha antiga não condiz";

        if(valido){
            usuario.alterarSenha(encoder.encode(request.senha_nova()));
        }

        return ResponseEntity.status(status).body(response);
    }
    @GetMapping("/usuario_dados")
    public ResponseEntity<UsuarioDadosDTO> dadosDoUsuario(@RequestParam String login){
        Optional<Usuario> optionalUsuario = repository.findUsuarioByLogin(login);

        //return (ResponseEntity<UsuarioDadosDTO>) ResponseEntity.notFound();
        return optionalUsuario.map(usuario -> ResponseEntity.ok(new UsuarioDadosDTO(usuario))).orElseGet(() -> ResponseEntity.ofNullable(new UsuarioDadosDTO()));
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
