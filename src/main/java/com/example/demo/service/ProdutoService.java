package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public void salvar(Produto p){
        repository.save(p);
    }

    public void excluir(Produto p){
        repository.delete(p);
    }

    public boolean excluirPorId(Long id){
        if (!prodtuoTemMovimentacao(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }        
    }     

    private boolean prodtuoTemMovimentacao(Long id) {
        return repository.existsByMovimentacoes_Id(id);
    }
        
    public Produto buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Produto> buscarTodos(){
        return repository.findAll();
    }
}
