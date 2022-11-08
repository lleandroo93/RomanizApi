package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.model.Uf;
import br.com.trilhabit.romaniz.repository.UfRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UfResources {
    
    @Autowired
    private UfRepository repository;
    
    @GetMapping("uf")
    public List<Uf> listAll() {
        return repository.findAll();
    }
}
