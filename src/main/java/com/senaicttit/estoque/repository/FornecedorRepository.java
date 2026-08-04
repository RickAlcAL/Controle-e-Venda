package com.senaicttit.estoque.repository;

import com.senaicttit.estoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    //A busca deve ser EXATAMENTE o nome da variavel NO JAVA !!!
    List<Fornecedor> findByNomeFornecedor(String nomeFornecedor);
}
