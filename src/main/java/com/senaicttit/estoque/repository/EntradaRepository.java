package com.senaicttit.estoque.repository;

import com.senaicttit.estoque.model.Entrada;
import com.senaicttit.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}
