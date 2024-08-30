package br.com.lucasaprigio.gestao_vagas.modules.company.controllers;

import br.com.lucasaprigio.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.lucasaprigio.gestao_vagas.modules.company.useCases.AuthCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    // Autowired para instanciar
    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    // postMapping para poder colocar o nome da rota
    @PostMapping("/company")
    // Sempre lembrar que é Tipo nomeVariável
    // Nesse acso abaixo, criamos um metodo create, que recebe como parametro o nosso DTO (username, password), e temos que respeitar o retorno dele, no caso o Authentication Exception.
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
        var result = this.authCompanyUseCase.execute(authCompanyDTO);

        // Aqui dará erro, caso não colocarmos ele como tipo antes do create
        return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
