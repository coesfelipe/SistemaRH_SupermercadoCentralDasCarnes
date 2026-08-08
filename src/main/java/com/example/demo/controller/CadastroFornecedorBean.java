package com.example.demo.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.model.Fornecedor;
import com.example.demo.service.FornecedorService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroFornecedorBean {
    @Getter @Setter
    private Fornecedor fornecedor;

    @Autowired
    private FornecedorService fornecedorService;

    @PostConstruct
    public void init(){
        fornecedor = new Fornecedor();
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        fornecedorService.salvar(fornecedor);

        // Prepara para cadastrar uma nova categoria
        fornecedor = new Fornecedor();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Cadastro efetuado.", "Fornecedor cadastrada com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro() {
            if (fornecedor.getId() != null) {
                fornecedor = fornecedorService.buscarPorId(fornecedor.getId());
            }
        }
}
