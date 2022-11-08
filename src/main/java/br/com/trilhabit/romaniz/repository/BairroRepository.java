package br.com.trilhabit.romaniz.repository;

import br.com.trilhabit.romaniz.model.Bairro;
import br.com.trilhabit.romaniz.model.Cidade;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BairroRepository extends JpaRepository<Bairro, UUID>{
    
    List<Bairro> findAllByCidade(Cidade cidade);
}
