package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Fornecedor;
import com.example.demo.repository.FornecedorRepository;

@Service
@Transactional(readOnly = true)
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    @Transactional(readOnly = false)
    public void salvar(Fornecedor f){
        repository.save(f);
    }

    @Transactional(readOnly = false)       
    public boolean excluirPorId(Long id){
        if (!fornecedorTemMovimentacao(id)){
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    private boolean fornecedorTemMovimentacao(Long id){
        return !buscarPorId(id).getMovimentacoes().isEmpty();
    }

    public Fornecedor buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Fornecedor> buscarTodos(){
        return repository.findAll();
    }
}
