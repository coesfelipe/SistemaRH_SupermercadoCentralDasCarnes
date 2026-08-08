package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fornecedor;
import com.example.demo.service.FornecedorService;

import lombok.Getter;
import lombok.Setter;

@Service
@Scope("view")
public class ConsultaFornecedoresBean {

    @Getter
    private List<Fornecedor> fornecedores;

    @Getter @Setter
    private Fornecedor fornecedorSelecionado;

    @Autowired
    private FornecedorService service;

    @PostConstruct
    public void init() {
        fornecedores = service.buscarTodos();
    }

    public void excluir() {
    FacesContext context = FacesContext.getCurrentInstance();

    if (fornecedorSelecionado == null || fornecedorSelecionado.getId() == null) {
        context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,
            "Erro",
            "Nenhum fornecedor selecionado."
        ));
        return;
    }

    if (service.excluirPorId(fornecedorSelecionado.getId())) {
        context.addMessage(null, new FacesMessage(
            "Exclusão",
            "Fornecedor excluído com sucesso."
        ));

        fornecedores = service.buscarTodos();
        fornecedorSelecionado = null;
    }
}
}