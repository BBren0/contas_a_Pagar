package br.com.cp.api_cp.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cp.api_cp.Modelo.Despesa;
import br.com.cp.api_cp.Modelo.Mensagem;
import br.com.cp.api_cp.Repositorio.DespesaRepository;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private DespesaRepository despesaRepository;
    
    //Método Cadastrar Despesas
    public ResponseEntity<?> cadastrar(Despesa despesa){
       if(despesa.getDescricao().equals("")){
        //mensagem.setMensagem("O nome precisa ser preenchido!");    
        throw new validDescription ("O nome precisa ser preenchido");
       }else if (despesa.getValor()<0) {
            throw new validNumber("Informe um valor maior que ZERO!");  
       }else{
            despesaRepository.save(despesa);
            return new ResponseEntity<>(despesaRepository.save(despesa), HttpStatus.CREATED);
       }
    }
    
    //Método para listar pessoas
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(despesaRepository.findAll(), HttpStatus.OK);
    }

    //Método selecionar através do código
    public ResponseEntity<?> reserchDespesa(int id){
        if (despesaRepository.countById(id)==0) {
            mensagem.setMensagem("Não foi encontrada nenhuma DESPESA");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(despesaRepository.findById(id),HttpStatus.OK);
        }
    }

    //Método para editar despesas
    public ResponseEntity<?> editar(Despesa despesa){
        if (despesaRepository.countById(despesa.getId())==0) {
            mensagem.setMensagem("O código informado NÃO EXISTE!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if (despesa.getDescricao().equals("")) {
            mensagem.setMensagem("É necessário informar o nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(despesa.getValor()<0){
            mensagem.setMensagem("Informe um valor MAIOR que 0 ");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(despesaRepository.save(despesa), HttpStatus.OK);
        }
    }

    //Método para deletar despesas
    public ResponseEntity<?> deletar(int id){
        if(despesaRepository.countById(id)==0){
            mensagem.setMensagem("O código informado não EXISTE!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            Despesa despesa = despesaRepository.findById(id);
            despesaRepository.delete(despesa);
            mensagem.setMensagem("Registro deletado com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

}

