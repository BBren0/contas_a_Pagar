package br.com.cp.api_cp.Repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cp.api_cp.Modelo.Despesa;


@Repository
public interface DespesaRepository extends CrudRepository<Despesa,Integer> {
    List<Despesa>findAll();
    Despesa findById(int id);

    List<Despesa> findByOrderByDescricao();
    List<Despesa> findByDescricaoOrderById(String descricao);
    List<Despesa> findByDescricaoContaining(String termo);
    List<Despesa> findByDescricaoStartsWith(String termo);
    
    @Query(value="Select SUM(id) FROM despesas", nativeQuery = true)
    int somaID();

    @Query(value = "Select * FROM despesas WHERE valor >= :valor", nativeQuery = true)
    List<Despesa> valorMaiorIgual(float valor);

    int countById(int id);
    
           
        
} 
    
