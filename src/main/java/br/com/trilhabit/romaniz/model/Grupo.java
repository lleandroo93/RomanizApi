package br.com.trilhabit.romaniz.model;

import br.com.trilhabit.romaniz.model.dto.cadastro.grupo.CadastroGrupoDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaGrupoRetornoDto;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Grupo implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    private String nome;
    
    public Grupo(CadastroGrupoDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
    }
    
    public ConsultaGrupoRetornoDto toConsultaGrupoRetornoDto() {
        return new ConsultaGrupoRetornoDto(id, nome);
    }

}
