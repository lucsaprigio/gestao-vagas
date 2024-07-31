package br.com.lucasaprigio.gestao_vagas.modules.candidate;

import java.util.UUID;

import lombok.Data;

@Data // Importação feita do Lombok para colocar os getters e setters, sem ter que sujar o código.
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}