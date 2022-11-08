package br.com.trilhabit.romaniz.repository;

import br.com.trilhabit.romaniz.model.Uf;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UfRepository extends JpaRepository<Uf, UUID>{
}
