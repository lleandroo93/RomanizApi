package br.com.trilhabit.romaniz.repository;

import br.com.trilhabit.romaniz.model.Cidade;
import br.com.trilhabit.romaniz.model.Uf;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CidadeRepository extends JpaRepository<Cidade, UUID>{
    List<Cidade> findAllByUf(Uf uf);
}
