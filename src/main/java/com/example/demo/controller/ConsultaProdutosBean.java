package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

import lombok.*;

@Service
@Scope("view")
public class ConsultaProdutosBean {
    @Getter
    private List<Produto> produtos;
    @Getter @Setter
    private Produto produtoSelecionado;

    @Autowired
    private ProdutoService service;

    @PostConstruct
    public void init(){
        produtos = service.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove o produto do banco de dados
        if (service.excluirPorId(produtoSelecionado.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Produto excluída com sucesso."));
            //consultar();
            produtos = service.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Movimentação vinculado a este produto."));
        }
    }
    
}
