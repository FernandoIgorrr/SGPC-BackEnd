package com.api.sgpcbackend.controller;


import com.api.sgpcbackend.domain.model.Bolsista;
import com.api.sgpcbackend.domain.model.Supervisor;
import com.api.sgpcbackend.repository.SupervisorRepository;
import com.api.sgpcbackend.service.EmailService;
import com.api.sgpcbackend.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController
{
    @Autowired
    private SupervisorRepository repository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EmailService emailService;


    @GetMapping("/listar")
    public ResponseEntity<List<Supervisor>> listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid Supervisor supervisor)
    {
        return  cadastrar_(supervisor);
    }
    private ResponseEntity<String> cadastrar_(Supervisor supervisor)

    {

        if(repository.existsAllByEmail((supervisor.getEmail())))
            return new ResponseEntity<>("E-mail já cadastrado", HttpStatus.CONFLICT);
        if(repository.existsAllByLogin((supervisor.getLogin())))
            return new ResponseEntity<>("Login já cadastrado", HttpStatus.CONFLICT);

        String senha_temporaria = PasswordService.gerarSenhaTemporaria();
        System.out.println("\n\nSENHA TEMPORÁRIA:*******************\n" + senha_temporaria + "\n\n");
        supervisor.setSenha(encoder.encode(senha_temporaria));
        supervisor.setAtvio(true);

        repository.save(supervisor);


        String subject = "Solarium System Labs | Detalhes da nova conta - SGPC";

        String message =    "Bom dia " + supervisor.getNome() + "!!!\nAqui estão os detalhes da sua conta para se logar no SGPC:\n" +
                "Login:\t" + supervisor.getLogin() + "\n" +
                "Senha:\t" + senha_temporaria;

        emailService.sendEmail(supervisor.getEmail(),subject,message);

        return new ResponseEntity<>("Supervisor cadastrado com sucesso, oriente ao usuário a acessar o e-mail dele para checar suas informações de login",HttpStatus.CREATED);
    }
}
