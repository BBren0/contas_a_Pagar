package br.com.cp.api_cp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Responsabilidade do banco de dados gerar o ID
    private long id;
    
    @Column(nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
    