package br.com.lucasaprigio.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasaprigio.gestao_vagas.modules.candidate.CandidateEntity;

@RestController
@RequestMapping("/candidate") // endpoint
public class CandidateController {

    @PostMapping("/") // Método POST na raíz ficará /candidate
    public void create(@RequestBody CandidateEntity candidateEntity) { // Estou pegando todas as informações da Entidade do meu Body
        System.out.println("Candidato");
        System.out.println(candidateEntity.getEmail());
    }
}
