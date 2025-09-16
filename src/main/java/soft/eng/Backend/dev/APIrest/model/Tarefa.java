// src/main/java/soft/eng/Backend/dev/APIrest/model/Tarefa.java
package soft.eng.Backend.dev.APIrest.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica que esta classe é uma entidade JPA
public class Tarefa {

    @Id // Mapeia o campo id como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o id será gerado automaticamente pelo banco de dados
    private Long id;
    
    @Column(name = "nome", nullable = false) // Mapeia a coluna 'nome' no banco e a define como não nula
    private String nome;
    
    @Column(name = "data_entrega") // Mapeia a coluna 'data_entrega'
    private String dataEntrega;
    
    @Column(name = "responsavel") // Mapeia a coluna 'responsavel'
    private String responsavel;

    // Construtor vazio é necessário para o JPA
    public Tarefa() {
    }

    // Getters e Setters para cada atributo (mais fácil de entender do que o Lombok, por enquanto)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    // Métodos utilitários para comparação de objetos
    @Override
    public int hashCode() {
        return Objects.hash(dataEntrega, id, nome, responsavel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        return Objects.equals(dataEntrega, other.dataEntrega) && Objects.equals(id, other.id)
                && Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
    }
}