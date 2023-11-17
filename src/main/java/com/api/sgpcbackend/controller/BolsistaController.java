package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.BolsistaCadastroDTO;
import com.api.sgpcbackend.domain.model.Bolsista;
import com.api.sgpcbackend.repository.BolsistaRepository;
import com.api.sgpcbackend.service.EmailService;
import com.api.sgpcbackend.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bolsista")
public class BolsistaController
{
    private final BolsistaRepository repository;
    private final PasswordEncoder encoder;
    private final EmailService emailService;

    public BolsistaController(BolsistaRepository repository, PasswordEncoder encoder, EmailService emailService) {
        this.repository = repository;
        this.encoder = encoder;
        this.emailService = emailService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Bolsista>> listar()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid BolsistaCadastroDTO bolsistaDTO)
    {
        return cadastrar_(bolsistaDTO);
    }

    public ResponseEntity<String> cadastrar_(BolsistaCadastroDTO bolsistaDTO)
    {
        Bolsista bolsista = new Bolsista(bolsistaDTO);

        if(repository.existsAllByMatricula(bolsista.getMatricula()))
            return new ResponseEntity<>("Matrícula já cadastrada", HttpStatus.CONFLICT);
        if(repository.existsAllByEmail((bolsista.getEmail())))
            return new ResponseEntity<>("E-mail já cadastrado", HttpStatus.CONFLICT);
        if(repository.existsAllByLogin((bolsista.getLogin())))
            return new ResponseEntity<>("Login já cadastrado", HttpStatus.CONFLICT);

        String senha_temporaria = PasswordService.gerarSenhaTemporaria();
        System.out.println("\n\nSENHA TEMPORÁRIA:*******************\n" + senha_temporaria + "\n\n");
        bolsista.setSenha(encoder.encode(senha_temporaria));
        //bolsista.setAtvio(true);

        repository.save(bolsista);


        String subject = "Solarium System Labs | Detalhes da nova conta - SGPC";

        String message =    "Bom dia " + bolsista.getNome() + "!!!\nAqui estão os detalhes da sua conta para se logar no SGPC:\n" +
                "Login:\t" + bolsista.getLogin() + "\n" +
                "Senha:\t" + senha_temporaria;

        emailService.sendEmail(bolsista.getEmail(),subject,message);

        return new ResponseEntity<>("Bolsista cadastrado com sucesso, oriente ao usuário a acessar o e-mail dele para checar suas informações de login",HttpStatus.CREATED);
    }
}
