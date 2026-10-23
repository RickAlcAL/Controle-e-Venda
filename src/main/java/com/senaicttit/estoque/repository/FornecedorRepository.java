package com.senaicttit.estoque.repository;

import com.senaicttit.estoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    Optional<Fornecedor> findByCpfOucnpjFornecedor(String cpf_ou_cnpj);
    Optional<Fornecedor> findByEmailFornecedor(String email_fornecedor);
    List<Fornecedor> findByNomeFornecedor(String nomeFornecedor);
}
