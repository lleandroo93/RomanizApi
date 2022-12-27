package br.com.trilhabit.romaniz.model.dto.cadastro.evento;

import java.util.Date;
import java.util.UUID;

public record CadastroEventoDto(
        Date dataInicio,
        Date dataFim,
        CadastroEventoContatoDto contato,
        String titulo,
        String descricao,
        UUID municipio,
        UUID bairro,
        UUID endereco,
        String observacao) {

}
