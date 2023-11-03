package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.model.BolsistaModel;
import com.api.sgpcbackend.repository.BolsistaRepository;
import com.api.sgpcbackend.service.EmailService;
import com.api.sgpcbackend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bolsista")
public class BolsistaController
{
    private final BolsistaRepository repository;
    private final PasswordEncoder encoder;
    private final EmailService emailService;
    public BolsistaController(BolsistaRepository repository, PasswordEncoder encoder, EmailService emailService) {
        this.repository = repository;
        this.encoder    = encoder;
        this.emailService = emailService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<BolsistaModel>> listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody BolsistaModel bolsista)
    {
        return cadastrar_(bolsista);
    }

    private ResponseEntity<String> cadastrar_(BolsistaModel bolsista)
    {

        if(repository.existsAllByMatricula(bolsista.getMatricula()))
        {
            return new ResponseEntity<>("Matricula já cadastrada",HttpStatus.BAD_REQUEST);
        }

        if(repository.existsAllByEmail(bolsista.getEmail()))
        {
            return new ResponseEntity<>("Email já cadastrado",HttpStatus.BAD_REQUEST);
        }

        if(repository.existsAllByLogin(bolsista.getLogin()))
        {
            return new ResponseEntity<>("Login já cadastrado",HttpStatus.BAD_REQUEST);
        }

        String senha_temporaria = UsuarioService.gerarSenhaTemporaria();
        System.out.println("\n\nSENHA TEMPORÁRIA:*******************\n" + senha_temporaria + "\n\n");
        bolsista.setSenha(senha_temporaria);
        bolsista.setSenha(encoder.encode(bolsista.getSenha()));
        bolsista.setTipo_usuario( (short)1 );
        bolsista.setStatus(true);

        repository.save(bolsista);

        String subject = "Solarium System Labs | Detalhes da nova conta - SGPC";

        String message =    "Bom dia " + bolsista.getNome() + "!!! Aqui estão os detalhes da sua conta: " +
                            "Login:\t" + bolsista.getLogin() + "\n" +
                            "Senha:\t" + senha_temporaria;

        emailService.sendEmail(bolsista.getEmail(),subject,message);

        return new ResponseEntity<>("Bolsista cadastrado com sucesso, por favor vá até o seu E-mail e configura os detalhes " +
            "da conta para se logar no sistema",HttpStatus.CREATED);
    }
}
