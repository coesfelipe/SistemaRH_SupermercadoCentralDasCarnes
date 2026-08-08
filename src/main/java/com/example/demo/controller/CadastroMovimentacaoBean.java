package com.example.demo.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fornecedor;
import com.example.demo.model.Movimentacao;
import com.example.demo.model.Produto;
import com.example.demo.service.FornecedorService;
import com.example.demo.service.MovimentacaoService;
import com.example.demo.service.ProdutoService;

import lombok.*;

@Service
@Scope("view")
public class CadastroMovimentacaoBean {
    @Getter @Setter
    private Movimentacao movimentacao;
    @Getter
    private List<Movimentacao> todasMovimentacoes;

    @Autowired
    private MovimentacaoService service;
    @Autowired
    private MovimentacaoService serviceMovimentacao;

    @Autowired
    private ProdutoService serviceProduto;

    @Getter
    private List<Produto> produtos;

    @Autowired
    private FornecedorService serviceFornecedor;

    @Getter
    private List<Fornecedor> fornecedores;

    @Getter @Setter
    private Long produtoId;

    @Getter @Setter
    private Long fornecedorId;

    @PostConstruct
    public void init(){
        movimentacao = new Movimentacao();    
        todasMovimentacoes = serviceMovimentacao.buscarTodos();   
        produtos = serviceProduto.buscarTodos(); 
        fornecedores = serviceFornecedor.buscarTodos(); 
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();

        Produto produto = serviceProduto.buscarPorId(produtoId);
        Fornecedor fornecedor = serviceFornecedor.buscarPorId(fornecedorId);

        movimentacao.setProduto(produto);
        movimentacao.setFornecedor(fornecedor);

        service.salvar(movimentacao);

        movimentacao = new Movimentacao();
        produtoId = null;
        fornecedorId = null;

        context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_INFO,
            "Movimentação efetuada.",
            "Movimentação cadastrada com sucesso."
        ));
    }

    public void prepararCadastro(){
        movimentacao = service.buscarPorId(movimentacao.getId());
    }
    
}
