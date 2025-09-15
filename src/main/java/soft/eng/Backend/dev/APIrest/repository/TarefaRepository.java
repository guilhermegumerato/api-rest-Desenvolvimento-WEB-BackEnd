package soft.eng.Backend.dev.APIrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soft.eng.Backend.dev.APIrest.model.Tarefa;

@Repository // Anotação para indicar que é um componente de acesso a dados
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}