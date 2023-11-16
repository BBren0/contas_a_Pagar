package br.com.cp.api_cp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contas_a_Pagar")

public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;
    
    @GetMapping
    public List<Despesa>  Listar(){
        return despesaRepository.findAll();
    }

    @PostMapping("/despesa")
    @ResponseStatus (HttpStatus.CREATED)
    public Despesa adicionar (@RequestBody Despesa despesa) {
        return despesaRepository.save(despesa);
    }

     @GetMapping("/despesa/{id}")
    public Despesa researchDespesa(@PathVariable int id){
        return despesaRepository.findById(id);
    }

    @PutMapping("/despesa")
    public Despesa editDespesa(@RequestBody Despesa despesa){
        return despesaRepository.save(despesa);
    }

    @DeleteMapping("/delete/{id}")
    public void  removerDespesa(@PathVariable int id){
        Despesa despesa = researchDespesa(id);
        despesaRepository.delete(despesa);
    }

    @GetMapping("/despesa/cout")
    public long contarRegistros(){
        return despesaRepository.count();
    }

    @GetMapping("/despes/ordenar")
    public List<Despesa> ordenarDespesas(){
        return despesaRepository.findByOrderBydescricao();
    }


}
