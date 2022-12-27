package br.com.trilhabit.romaniz.resources;

import br.com.trilhabit.romaniz.model.Bairro;
import br.com.trilhabit.romaniz.model.Cidade;
import br.com.trilhabit.romaniz.model.Pessoa;
import br.com.trilhabit.romaniz.model.Uf;
import br.com.trilhabit.romaniz.model.dto.cadastro.pessoa.CadastroPessoaDto;
import br.com.trilhabit.romaniz.model.dto.consulta.ConsultaPessoaRetornoDto;
import br.com.trilhabit.romaniz.repository.BairroRepository;
import br.com.trilhabit.romaniz.repository.CidadeRepository;
import br.com.trilhabit.romaniz.repository.PessoaRepository;
import br.com.trilhabit.romaniz.repository.UfRepository;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/pessoa")
public class PessoaResources {

    @Autowired
    private PessoaRepository repository;
    @Autowired
    private UfRepository ufRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private BairroRepository bairroRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> pessoas = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ConsultaPessoaRetornoDto>> criteria(
            @RequestParam String criteria,
            @RequestParam(required = false, defaultValue = "100") Integer limit) {
        Page<Pessoa> result = repository.findByNomeIgnoreCaseContaining(criteria, PageRequest.of(0, limit, Sort.by(Sort.Direction.ASC, "nome")));
        return ResponseEntity.status(HttpStatus.OK).body(result.get().map(p -> p.toConsultaPessoaRetornoDto()).toList());
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody CadastroPessoaDto dto) {
        System.out.println("Criando pessoa " + dto);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setEndereco(dto.endereco());
        pessoa.setTelefone(dto.telefone());
        pessoa.setGrupo(dto.grupo());
        pessoa.setResumo(dto.resumo());
        if (dto.uf() != null) {
            Optional<Uf> optUf = ufRepository.findById(dto.uf());
            pessoa.setUf(optUf.orElse(null));
        }
        if (dto.cidade() != null) {
            Optional<Cidade> optCidade = cidadeRepository.findById(dto.uf());
            pessoa.setCidade(optCidade.orElse(null));
        }
        if (dto.bairro() != null) {
            Optional<Bairro> optBairro = bairroRepository.findById(dto.uf());
            pessoa.setBairro(optBairro.orElse(null));
        }
        pessoa.setGoogleMaps(dto.googleMaps());

        Pessoa save = repository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
