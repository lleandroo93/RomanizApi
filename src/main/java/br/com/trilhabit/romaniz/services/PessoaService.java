package br.com.trilhabit.romaniz.services;

import br.com.trilhabit.romaniz.model.Pessoa;
import br.com.trilhabit.romaniz.repository.PessoaRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    
    public Optional<Pessoa> selecionar(UUID id) {
        return repository.findById(id);
    }

    public Pessoa salvar(Pessoa novaPessoa) {
        return repository.save(novaPessoa);
    }
}
