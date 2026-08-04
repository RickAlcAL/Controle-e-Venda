package com.senaicttit.estoque.service;

import com.senaicttit.estoque.model.ItensVenda;
import com.senaicttit.estoque.model.Produto;
import com.senaicttit.estoque.model.Venda;
import com.senaicttit.estoque.repository.ItensVendaRepository;
import com.senaicttit.estoque.repository.ProdutoRepository;
import com.senaicttit.estoque.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensVendaService {

    @Autowired
    private ItensVendaRepository itensVendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public ItensVenda salvandoItens (ItensVenda itensVenda) {
        //Criando uma variavel para pegar o id da venda
        Integer idVenda = itensVenda.getVendas().getIdVenda();
        //Se existir eu pego e atribuo diretamente ao construtor
        Venda vendaExistente = vendaRepository.findById(idVenda)
                .orElseThrow(() -> new RuntimeException("Venda com ID " + idVenda + " não encontrada!"));

        //Criando uma variavel para pegar o id do produto
        Integer idProduto = itensVenda.getProduto().getId();
        //Se existir eu pego e atribuo diretamente ao construtor
        Produto produtoExistente = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + idProduto + " não encontrado!"));

        itensVenda.setVendas(vendaExistente);
        itensVenda.setProduto(produtoExistente);

        return itensVendaRepository.save(itensVenda);
    }

    public List<ItensVenda> listarItensVendas() {
        return itensVendaRepository.findAll();
    }
}
