package com.example.demo.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroCategoriaBean {
    @Getter @Setter
    private Categoria categoria;

    @Autowired
    private CategoriaService categoriaService;

    @PostConstruct
    public void init(){
        categoria = new Categoria();
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        categoriaService.salvar(categoria);

        // Prepara para cadastrar uma nova categoria
        categoria = new Categoria();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Cadastro efetuado.", "Categoria cadastrada com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro() {
            if (categoria.getId() != null) {
                categoria = categoriaService.buscarPorId(categoria.getId());
            }
        }
}
