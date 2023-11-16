package br.com.cp.api_cp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DespesaRepository extends CrudRepository<Despesa,Integer> {
    List<Despesa>findAll();
    Despesa findById(int id);

    List<Despesa> findByOrderByDescricao();
    List<Despesa> findByDescricaoOrderById(String descricao);
    List<Despesa> findByDescricaoContaining(String termo);
    List<Despesa> findByDescricaoStartsWith(String termo);
    //List<Despesa> findByDescricaoEndstsWith(String termo);

    //
    @Query(value="Select SUM(id) FROM despesas", nativeQuery = true)
    int somaID();

    @Query(value = "Select * FROM despesas WHERE valor >= :valor", nativeQuery = true)
    List<Despesa> valorMaiorIgual(float valor);

    
           
        
} 
    
