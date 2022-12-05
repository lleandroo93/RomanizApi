package br.com.trilhabit.romaniz.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Pessoa implements Serializable{
    
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
}
