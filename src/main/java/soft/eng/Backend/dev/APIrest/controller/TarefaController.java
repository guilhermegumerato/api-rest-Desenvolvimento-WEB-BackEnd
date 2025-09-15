package soft.eng.Backend.dev.APIrest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soft.eng.Backend.dev.APIrest.model.Tarefa;
import soft.eng.Backend.dev.APIrest.repository.TarefaRepository;

@RestController // Indica que a classe é um controlador REST
@RequestMapping({ "/tarefas" }) // Define o caminho base para todos os endpoints deste controlador
public class TarefaController {

    private final TarefaRepository repository;

    TarefaController(TarefaRepository tarefaRepository) {
        this.repository = tarefaRepository;
    }

    // Método para listar todas as tarefas
    @GetMapping
    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    // Método para buscar uma tarefa por ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para criar uma nova tarefa
    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    // Método para atualizar uma tarefa existente
    @PutMapping(path = "/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(tarefa.getNome());
                    record.setDataEntrega(tarefa.getDataEntrega());
                    record.setResponsavel(tarefa.getResponsavel());
                    Tarefa updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para remover uma tarefa por ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}