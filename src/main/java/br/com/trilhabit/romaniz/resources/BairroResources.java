package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.exceptions.CidadeNotFoundException;
import br.com.trilhabit.romaniz.model.Bairro;
import br.com.trilhabit.romaniz.model.Cidade;
import br.com.trilhabit.romaniz.repository.BairroRepository;
import br.com.trilhabit.romaniz.repository.CidadeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BairroResources {
    
    @Autowired
    private BairroRepository repository;
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping("cidade/{cidade_id}/bairro")
    public ResponseEntity listAllFromCidade(@PathVariable UUID cidade_id) {
        Optional<Cidade> optCidade = cidadeRepository.findById(cidade_id);
        if (optCidade.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Bairro> bairros = repository.findAllByCidade(optCidade.get());
        return ResponseEntity.ok(bairros);
    }
}
