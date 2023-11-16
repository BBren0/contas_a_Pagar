package br.com.cp.api_cp;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity //Ele especifica a criação de uma tabela
@Table(name="Despesas")
public class Despesa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Responsabilidade do banco de dados gerar o ID
    private int id;
    
    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private float valor;
    
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    @Column(nullable = true)
    private LocalDate vencimento;

   
}
    