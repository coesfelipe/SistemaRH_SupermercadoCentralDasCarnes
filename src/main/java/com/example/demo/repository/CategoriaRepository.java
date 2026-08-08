package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public boolean existsByProdutos_Id(Long id);
    //*** pesquisa pelo nome exato */
    public List<Categoria> findByNome(String nome);
    //*** pesquisa por parte do nome */
    public List<Categoria> findByNomeContaining(String nome);
    //*** pesquisa por uma faixa de Ids */
    public List<Categoria> findByIdBetween(Long ini, Long fim);
    //*** pesquisa pelo id e o nome da categoria ao mesmo tempo */
    public List<Categoria> findByIdAndNome(Long ini, String nome);
}
