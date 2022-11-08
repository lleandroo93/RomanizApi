package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.exceptions.UfNotFoundException;
import br.com.trilhabit.romaniz.model.Cidade;
import br.com.trilhabit.romaniz.model.Uf;
import br.com.trilhabit.romaniz.repository.CidadeRepository;
import br.com.trilhabit.romaniz.repository.UfRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CidadeResources {
    
    @Autowired
    private CidadeRepository repository;
    @Autowired
    private UfRepository UfRepository;
    
    @GetMapping("uf/{uf_id}/cidade")
    public List<Cidade> listAllFromUf(@PathVariable UUID uf_id) {
        Optional<Uf> optUf = UfRepository.findById(uf_id);
        if (optUf.isEmpty()) {
            throw new UfNotFoundException();
        }
        return repository.findAllByUf(optUf.get());
    }
}
