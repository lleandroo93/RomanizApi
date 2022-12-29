package br.com.trilhabit.romaniz.model.dto.consulta;

import java.util.UUID;

public record ConsultaEventoRetornoDto(
        UUID id,
        String titulo,
        String contato,
        long dataInicio,
        Long dataFim,
        String resumo,
        String endereco,
        String observacao) {
    
}
