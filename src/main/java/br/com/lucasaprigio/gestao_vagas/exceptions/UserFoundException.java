package br.com.lucasaprigio.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário ja existe");
    }
}
