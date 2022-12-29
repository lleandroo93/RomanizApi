package br.com.trilhabit.romaniz.repository;

import br.com.trilhabit.romaniz.model.Grupo;
import br.com.trilhabit.romaniz.model.Pessoa;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, UUID>{

    public Page<Grupo> findByNomeIgnoreCaseContaining(String nome, PageRequest of);
    
}
