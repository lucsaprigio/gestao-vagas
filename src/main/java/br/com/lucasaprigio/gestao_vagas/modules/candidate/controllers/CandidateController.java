package br.com.lucasaprigio.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasaprigio.gestao_vagas.exceptions.UserFoundException;
import br.com.lucasaprigio.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.lucasaprigio.gestao_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate") // endpoint
public class CandidateController {

    @Autowired // O spring sempre vai instanciar nossa classe
    private CandidateRepository candidateRepository;

    @PostMapping("/") // Método POST na raíz ficará /candidate/
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) { // Estou pegando todas as informações da Entidade do meu Body
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
            
        return this.candidateRepository.save(candidateEntity);
    }
}
