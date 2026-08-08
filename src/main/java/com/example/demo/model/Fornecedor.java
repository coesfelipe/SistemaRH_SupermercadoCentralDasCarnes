package com.example.demo.model;

import java.util.List;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Fornecedor extends AbstractEntity<Long>{
    
    private String nome;
    private String email;
    private String cnpj;
    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    private List<Movimentacao> movimentacoes;
}
