package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    
}
