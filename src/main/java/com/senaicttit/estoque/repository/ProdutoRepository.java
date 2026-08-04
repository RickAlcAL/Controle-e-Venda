package com.senaicttit.estoque.repository;

import com.senaicttit.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Criando uma classe Interface
//Classe interface não recebe codigo ela apenas dá o rumo dos metodos
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    //Instanciando uma lista de procuro onde o Spring Boot vai fazer a busca por baxo dos panos
    //Estou pedindo uma busca por nome
    List<Produto> findBynomeProduto(String nomeProduto);
}
