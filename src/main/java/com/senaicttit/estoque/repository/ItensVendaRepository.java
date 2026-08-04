package com.senaicttit.estoque.repository;

import com.senaicttit.estoque.model.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer> {
}
