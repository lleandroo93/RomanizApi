package br.com.trilhabit.romaniz.services;

import br.com.trilhabit.romaniz.model.Evento;
import br.com.trilhabit.romaniz.model.Pessoa;
import br.com.trilhabit.romaniz.model.dto.cadastro.evento.CadastroEventoDto;
import br.com.trilhabit.romaniz.repository.EventoRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        Evento evento = populaEvento(dto);
        return repository.save(evento);
    }

    public Evento alterarEvento(String id, CadastroEventoDto dto) {
        Optional<Evento> optEvento = repository.findById(UUID.fromString(id));
        if (optEvento.isPresent()) {
            Evento eventoOld = optEvento.get();
            Evento eventoNew = populaEvento(dto);
            
            eventoNew.setId(eventoOld.getId());
            return repository.save(eventoNew);
        } else {
            return null;
        }
    }

    private Evento populaEvento(CadastroEventoDto dto) {
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
        return evento;
    }
}
