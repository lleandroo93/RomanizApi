package br.com.trilhabit.romaniz.model;

import br.com.trilhabit.romaniz.model.dto.cadastro.evento.CadastroEventoDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaEventoRetornoDto;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Evento implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    private String titulo;
    private String descricao;
    private String observacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;
//    private Endereco enderecoDiferente;
    private String status;

    public Evento(CadastroEventoDto dto) {
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
        this.observacao = dto.observacao();
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
    }

    public ConsultaEventoRetornoDto toConsultaEventoRetornoDto() {
        return new ConsultaEventoRetornoDto(
                id,
                titulo,
                pessoa == null ? null : pessoa.getNome(),
                dataInicio.getTime(),
                dataFim == null ? null : dataFim.getTime(),
                descricao,
                "",
                observacao);
    }
}
