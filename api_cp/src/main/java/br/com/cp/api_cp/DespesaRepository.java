package br.com.cp.api_cp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends CrudRepository<Despesa,Long> {
    List<Despesa>findAll();
    Despesa findById(int id);
    List<Despesa> findByOrderBydescricao();
    
        
} 
    
