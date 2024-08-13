package br.com.lucasaprigio.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasaprigio.gestao_vagas.exceptions.UserFoundException;
import br.com.lucasaprigio.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.lucasaprigio.gestao_vagas.modules.candidate.CandidateRepository;

// Onde vai estar nossa regra de negócio, nesse caso, ele Cria um candidato no banco de dados
@Service
public class CreateCandidateUseCase {

    @Autowired // O spring sempre vai instanciar nossa classe
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
