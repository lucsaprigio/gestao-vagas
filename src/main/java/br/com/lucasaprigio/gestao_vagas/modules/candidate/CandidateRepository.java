package br.com.lucasaprigio.gestao_vagas.modules.candidate;

// Criamos como interface para extendermos para o JPA

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
