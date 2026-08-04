package com.senaicttit.estoque.service;

import com.senaicttit.estoque.model.ItensVenda;
import com.senaicttit.estoque.model.Produto;
import com.senaicttit.estoque.model.Venda;
import com.senaicttit.estoque.repository.ItensVendaRepository;
import com.senaicttit.estoque.repository.ProdutoRepository;
import com.senaicttit.estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendaService {

   @Autowired
    private VendaRepository vendaRepository;


   public Venda salvandoVenda (Venda venda) {
       return vendaRepository.save(venda);

   }

   public List<Venda> buscandoVendas () {
        return vendaRepository.findAll();
   }
}
