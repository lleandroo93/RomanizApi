package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.model.Grupo;
import br.com.trilhabit.romaniz.model.dto.cadastro.grupo.CadastroGrupoDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaGrupoRetornoDto;
import br.com.trilhabit.romaniz.repository.GrupoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
public class GrupoResources {

    @Autowired
    private GrupoRepository repository;

    @GetMapping
    public ResponseEntity<List<ConsultaGrupoRetornoDto>> listar() {
        List<Grupo> grupos = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(grupos.stream().map(p -> p.toConsultaGrupoRetornoDto()).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ConsultaGrupoRetornoDto>> criteria(
            @RequestParam String criteria,
            @RequestParam(required = false, defaultValue = "100") Integer limit) {
        Page<Grupo> result = repository.findByNomeIgnoreCaseContaining(criteria, PageRequest.of(0, limit, Sort.by(Sort.Direction.ASC, "nome")));
        return ResponseEntity.status(HttpStatus.OK).body(result.get().map(p -> p.toConsultaGrupoRetornoDto()).toList());
    }

    @PostMapping()
    public ResponseEntity<Grupo> create(@RequestBody CadastroGrupoDto dto) {
        System.out.println("Criando grupo " + dto);

        Grupo grupo = new Grupo();
        grupo.setNome(dto.nome());

        Grupo save = repository.save(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

}
