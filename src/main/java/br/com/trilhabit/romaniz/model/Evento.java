package br.com.trilhabit.romaniz.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Evento implements Serializable {
    
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    private String titulo;
    private String descricao;
    private String observacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
//    private Pessoa pessoa;
//    private Endereco enderecoDiferente;
    private String status;
}
