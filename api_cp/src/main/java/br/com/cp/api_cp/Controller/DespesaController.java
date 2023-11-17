package br.com.cp.api_cp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cp.api_cp.Modelo.Despesa;
import br.com.cp.api_cp.Repositorio.DespesaRepository;
import br.com.cp.api_cp.Servico.Servico;
import br.com.cp.api_cp.Servico.validDescription;
import br.com.cp.api_cp.Servico.validNumber;


@RestController
@RequestMapping("/contas_a_Pagar")

public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;
    
    @Autowired
    private Servico servico;

    //Apresenta todas as despesas cadastradas
    @GetMapping
    public ResponseEntity<?>  Listar(){
        return servico.selecionar();
    }

    //Criada a despesas no banco de dados
    @PostMapping("/despesa")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<?> adicionar (@RequestBody Despesa despesa) {
        try {
            return servico.cadastrar(despesa);
            
        } catch (validNumber e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (validDescription e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
        

    //Pesquisa uma despesa pelo ID
     @GetMapping("/despesa/{id}")
    public ResponseEntity<?> researchDespesa(@PathVariable int id){
        return servico.reserchDespesa(id);
    }

    //Edita uma despesa pelo banco de dados (obs.: coloca o ID da despesa que quer cadastrar)//
    @PutMapping("/despesa/editar")
    public ResponseEntity<?> editDespesa(@RequestBody Despesa despesa){
        return servico.editar(despesa);
    }

    //Deleta uma despesa no banco de dados
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  removerDespesa(@PathVariable int id){
        return servico.deletar(id);
    }

    //Conta quantos registros há no banco de dados
    @GetMapping("/despesa/cout")
    public long contarRegistros(){
        return despesaRepository.count();
    }

    //Ordena todas as despesas pela descrição
    @GetMapping("/despesa/order")
    public List<Despesa> ordenarDespesa(){
        return despesaRepository.findByOrderByDescricao();
    }

    //Filtra todas as despesas com uma determinada descrição e ordena pelo ID
    @GetMapping("/despesa/filtrar")
    public List<Despesa> filtrarDespesas(){
        return despesaRepository.findByDescricaoOrderById("Conta de água");
    }

    //Filtra todas as despesas que contenham o caracter letra A
    @GetMapping("/despesa/filtrarC")
    public List<Despesa> filtroCaracter(){
        return despesaRepository.findByDescricaoContaining("A");
    }

    //Filtra pelas despesas em que a descrição inicia com a letra C
    @GetMapping("/despesa/startswith")
    public List<Despesa> startsWith(){
        return despesaRepository.findByDescricaoStartsWith("T");
    }
        
    //Soma os ID's de todas as despesas presentes no banco de dados
    @GetMapping("/despesa/somarID")
    public int somaID(){
        return despesaRepository.somaID();
    }

    //Filtra todas as despesas com valor maior ou iagual a um determinado número
    @GetMapping("/despesa/filtroValor")
    public List<Despesa> valorMaiorIgual(){
        return despesaRepository.valorMaiorIgual(100);
    }
    
}
