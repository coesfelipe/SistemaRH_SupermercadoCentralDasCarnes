package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Movimentacao extends AbstractEntity<Long>{
    
    private String tipoMovimentacao;
    private int qtde;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor_fk")
    private Fornecedor fornecedor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;
}
