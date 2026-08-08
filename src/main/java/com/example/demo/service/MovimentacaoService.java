package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movimentacao;
import com.example.demo.repository.MovimentacaoRepository;


@Service
public class MovimentacaoService {
     @Autowired
    private MovimentacaoRepository repository;

    public void salvar(Movimentacao m){
        repository.save(m);
    }

    public void excluir(Movimentacao m){
        repository.delete(m);
    }

    public void excluirPorId(Long id){
        repository.deleteById(id);
    }

    public Movimentacao buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Movimentacao> buscarTodos(){
        return repository.findAll();
    }
    
}
