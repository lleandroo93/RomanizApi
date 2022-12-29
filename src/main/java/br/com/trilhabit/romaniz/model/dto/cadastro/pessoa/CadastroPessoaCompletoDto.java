package br.com.trilhabit.romaniz.model.dto.cadastro.pessoa;

import br.com.trilhabit.romaniz.model.dto.cadastro.grupo.CadastroGrupoDto;
import java.util.UUID;

public record CadastroPessoaCompletoDto(
        String nome,
        String endereco,
        String telefone,
        CadastroGrupoDto grupo,
        String resumo,
        UUID uf,
        UUID cidade,
        UUID bairro,
        String googleMaps) {

}
