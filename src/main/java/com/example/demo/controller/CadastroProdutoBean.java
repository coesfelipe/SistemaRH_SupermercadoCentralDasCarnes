package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Produto;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProdutoService;

import lombok.*;

@Service
@Scope("view")
public class CadastroProdutoBean {
    @Getter @Setter
    private Produto produto;
    @Getter
    private List<Categoria> todasCategorias;

    @Autowired
    private ProdutoService service;
    @Autowired
    private CategoriaService serviceCategoria;

    @PostConstruct
    public void init(){
        produto = new Produto();    
        todasCategorias = serviceCategoria.buscarTodos();    
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        service.salvar(produto);

        // Prepara para cadastrar um novo produto
        produto = new Produto();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Cadastro efetuado.", "Produto cadastrada com sucesso.");
        context.addMessage(null, mensagem);
    }

    public void prepararCadastro(){
        produto = service.buscarPorId(produto.getId());
    }
    
}
