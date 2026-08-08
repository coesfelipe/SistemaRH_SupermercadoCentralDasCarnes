package com.example.demo.model;

import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Produto extends AbstractEntity<Long>{
    
    private String nome;
    private int qtdeMinima;
    private int qtdeEstoque;
    private String unidadeMedida;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria_fk")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Movimentacao> movimentacoes;
}
