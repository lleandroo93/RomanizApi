package br.com.trilhabit.romaniz.model.dto.consulta;

import java.util.UUID;

public record ConsultaPessoaRetornoDto(
        UUID id,
        String nome,
        String telefone,
        String grupo,
        String endereco) {
    
}
