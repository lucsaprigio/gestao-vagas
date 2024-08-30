package br.com.lucasaprigio.gestao_vagas.modules.company.useCases;

import javax.naming.AuthenticationException;
import br.com.lucasaprigio.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.lucasaprigio.gestao_vagas.modules.company.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyUseCase {

    // Passamos como environment
    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        // Vamos procurar pele username do usuário, criamos um Optional no nosso Repository para poder user o orElseThrow
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("Username/password incorrect");
                });

        // Verificar a senha caso existir a company
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // Se não for igual > Erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // Se for igual > Gerar o token JWT
        Algorithm algorithm  = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("javagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);
        return token;
    }
}
