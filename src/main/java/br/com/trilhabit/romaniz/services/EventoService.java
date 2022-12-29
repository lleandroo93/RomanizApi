package br.com.trilhabit.romaniz.services;

import br.com.trilhabit.romaniz.model.Evento;
import br.com.trilhabit.romaniz.model.Pessoa;
import br.com.trilhabit.romaniz.model.dto.cadastro.evento.CadastroEventoDto;
import br.com.trilhabit.romaniz.repository.EventoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;
    @Autowired
    private PessoaService pessoaService;

    public List<Evento> listAll() {
        return repository.findAll();
    }

    public Evento novoEvento(CadastroEventoDto dto) {
        Pessoa contato = null;
        if (dto.contato() != null && dto.contato().id() != null) {
            Optional<Pessoa> optPessoa = pessoaService.selecionar(dto.contato().id());
            if (optPessoa.isPresent()) {
                contato = optPessoa.get();
            } else {
                Pessoa novaPessoa = new Pessoa();
                contato = pessoaService.salvar(novaPessoa);
            }
        }
        
        Evento evento = new Evento(dto);
        evento.setPessoa(contato);
        return repository.save(evento);
    }
}
