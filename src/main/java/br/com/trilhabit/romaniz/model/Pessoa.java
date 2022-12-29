package br.com.trilhabit.romaniz.model;

import br.com.trilhabit.romaniz.model.dto.cadastro.evento.CadastroEventoContatoDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaPessoaRetornoDto;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    private String nome;
    private String endereco;
    private String telefone;
    private String grupo;
    private String resumo;
    @ManyToOne
    private Uf uf;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Bairro bairro;
    @Column(name = "googlemaps")
    private String googleMaps;

    public Pessoa(CadastroEventoContatoDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
    }

    public ConsultaPessoaRetornoDto toConsultaPessoaRetornoDto() {
        return new ConsultaPessoaRetornoDto(
                id,
                nome,
                telefone,
                grupo,
                getEnderecoFormatado());
    }

    private String getEnderecoFormatado() {
        StringBuilder enderecoBuilder = new StringBuilder();

        if (endereco != null) {
            enderecoBuilder.append(endereco);
        }

        if (bairro != null || cidade != null || uf != null) {
            enderecoBuilder.append("(")
                    .append(bairro == null ? "" : bairro.getNome())
                    .append(bairro == null && cidade == null ? "" : "-")
                    .append(cidade == null ? "" : cidade.getNome())
                    .append(cidade == null && uf == null ? "" : "-")
                    .append(uf == null ? "" : uf.getNome())
                    .append(")");
        }

        return enderecoBuilder.toString();
    }
}
