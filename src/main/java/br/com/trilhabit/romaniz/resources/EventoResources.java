package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.model.Evento;
import br.com.trilhabit.romaniz.repository.EventoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoResources {
    
    @Autowired
    private EventoRepository repository;
    
    @GetMapping("evento")
    public List<Evento> listAll() {
         return repository.findAll();
    }
    
    @PostMapping("evento")
    public Evento create(@RequestBody Evento evento) {
        return repository.save(evento);
    }
}
