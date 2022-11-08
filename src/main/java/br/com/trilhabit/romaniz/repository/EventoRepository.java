package br.com.trilhabit.romaniz.repository;

import br.com.trilhabit.romaniz.model.Evento;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EventoRepository extends JpaRepository<Evento, UUID>{
    
}
