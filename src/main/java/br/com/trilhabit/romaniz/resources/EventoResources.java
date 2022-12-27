package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.model.Evento;
import br.com.trilhabit.romaniz.model.dto.cadastro.evento.CadastroEventoDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaEventoRetornoDto;
import br.com.trilhabit.romaniz.services.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoResources {

    @Autowired
    private EventoService service;

    @GetMapping("evento")
    public List<ConsultaEventoRetornoDto> listAll() {
        return service.listAll().stream().map(e -> e.toConsultaEventoRetornoDto()).toList();
    }

    @PostMapping("evento")
    public Evento create(@RequestBody CadastroEventoDto dto) {
        return service.novoEvento(dto);
    }
}
