package br.com.lucasaprigio.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // Importação feita do Lombok para colocar os getters e setters, sem ter que sujar o código.
@Entity(name = "candidate") // Definimos o nome da tabela.
public class CandidateEntity {

    @Id
    @GeneratedValue()
    private UUID id;

    private String name;

    @Pattern(regexp = "\\S+", message= "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo deve conter um [email] válido")
    private String email;

    @Length(min =10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}