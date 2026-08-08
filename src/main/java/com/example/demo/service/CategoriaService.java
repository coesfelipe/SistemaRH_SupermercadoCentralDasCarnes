package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public void salvar(Categoria c){
        repository.save(c);
    }

    public boolean excluirPorId(Long id){
        if (! categoriaTemProduto(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    private boolean categoriaTemProduto(Long id){
        return repository.existsByProdutos_Id(id);
    }   

    public Categoria buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<Categoria> buscarTodos(){
        return repository.findAll();
    }

    public List<Categoria> buscarPorNome(String nome){
        return repository.findByNomeContaining(nome);
    }

    public List<Categoria> buscarPorFaixaID(Long ini, Long fim){
        return repository.findByIdBetween(ini, fim);
    }

     public List<Categoria> buscarPorCategoria_Nome(Long id, 
                            String nome){
        return repository.findByIdAndNome(id, nome);
    }

    public long count() {
        return repository.count();
    }
    
}

