package com.api.sgpcbackend.controller;

import com.api.sgpcbackend.domain.dto.BolsistaCadastroDTO;
import com.api.sgpcbackend.domain.dto.BolsistaListarDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.ComputadorCadastroDTO;
import com.api.sgpcbackend.domain.dto.patrimonio.PatrimonioCadastroDTO;
import com.api.sgpcbackend.domain.model.Bolsista;
import com.api.sgpcbackend.domain.model.patrimonio.Computador;
import com.api.sgpcbackend.domain.model.patrimonio.Patrimonio;
import com.api.sgpcbackend.domain.roles.TipoBolsista;
import com.api.sgpcbackend.repository.BolsistaListarDTORepository;
import com.api.sgpcbackend.repository.BolsistaRepository;
import com.api.sgpcbackend.repository.roles.TipoBolsistaRepository;
import com.api.sgpcbackend.service.EmailService;
import com.api.sgpcbackend.service.PasswordService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/bolsista")
public class BolsistaController
{
    @Autowired
    private TipoBolsistaRepository tipoBolsistaRepository;

    @Autowired
    private  BolsistaRepository repository;

    @Autowired
    private BolsistaListarDTORepository bolsistaListarDTORepository;

    @Autowired
    private  PasswordEncoder encoder;

    @Autowired
    private  EmailService emailService;


    @GetMapping("/listar")
    public ResponseEntity<List<BolsistaListarDTO>> listar()
    {
        return ResponseEntity.ok(bolsistaListarDTORepository.findAll());
    }

    @PutMapping("/bolsista/atualizar")
    @Transactional
    public ResponseEntity<String> atualizarBolsista(@RequestBody @Valid BolsistaCadastroDTO dto)
    {
        Bolsista bolsista = repository.getReferenceById(dto.id());

        bolsista.setMatricula(dto.matricula());
        bolsista.setTipo_bolsista(new TipoBolsista(dto.tipo_bolsista()));

        bolsista.setNome(dto.nome());
        bolsista.setEmail(dto.email());
        bolsista.setTelefone(dto.telefone());

        return new ResponseEntity<>("Dados do bolsista alterados com sucesso", HttpStatus.ACCEPTED);
    }


    @GetMapping("/tipo/listar")
    public ResponseEntity<List<TipoBolsista>> listarTiposBolsista()
    {
        return ResponseEntity.ok(tipoBolsistaRepository.findAll());
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
        //System.out.println("\n\nSENHA TEMPORÁRIA:*******************\n" + senha_temporaria + "\n\n");
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
