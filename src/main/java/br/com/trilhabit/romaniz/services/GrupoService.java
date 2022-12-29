package br.com.trilhabit.romaniz.services;

import br.com.trilhabit.romaniz.model.Grupo;
import br.com.trilhabit.romaniz.repository.GrupoRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;
    
    public Optional<Grupo> selecionar(UUID id) {
        return repository.findById(id);
    }

    public Grupo salvar(Grupo novoGrupo) {
        return repository.save(novoGrupo);
    }
}
