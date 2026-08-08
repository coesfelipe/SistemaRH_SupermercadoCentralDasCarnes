package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movimentacao;
import com.example.demo.service.MovimentacaoService;

import lombok.Getter;
import lombok.Setter;

@Service
@Scope("view")
public class ConsultaMovimentacoesBean {
    @Getter
    private List<Movimentacao> movimentacoes;
    @Getter @Setter
    private Movimentacao movimentacaoSelecionada;

    @Autowired
    private MovimentacaoService service;

    @PostConstruct
    public void init(){
        movimentacoes = service.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
        "Selecione uma movimentação", "Para excluir, selecione uma movimentação."));
        }
        
    
}
