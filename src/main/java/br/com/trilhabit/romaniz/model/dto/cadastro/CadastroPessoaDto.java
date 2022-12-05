package br.com.trilhabit.romaniz.model.dto.cadastro;

import java.util.UUID;

public record CadastroPessoaDto(
        String nome,
        String endereco,
        String telefone,
        String grupo,
        String resumo,
        UUID uf,
        UUID cidade,
        UUID bairro,
        String googleMaps) {

}
