package br.com.lucasaprigio.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // Cria um constructor com o argumentos
public class ErrorMessageDTO {
    
    private String message;
    private String field;
}
