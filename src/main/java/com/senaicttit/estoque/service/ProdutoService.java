package com.senaicttit.estoque.service;


import com.senaicttit.estoque.model.Entrada;
import com.senaicttit.estoque.model.ItensVenda;
import com.senaicttit.estoque.model.Produto;
import com.senaicttit.estoque.model.Venda;
import com.senaicttit.estoque.model.enums.Metodo;
import com.senaicttit.estoque.repository.EntradaRepository;
import com.senaicttit.estoque.repository.ItensVendaRepository;
import com.senaicttit.estoque.repository.ProdutoRepository;

import com.senaicttit.estoque.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    //Usando o @Autowired para injetar as dependencias beans do Springboot falando que ProdutoRepository é manipulavel
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ItensVendaRepository itensVendaRepository;

    @Autowired
    private VendaRepository vendaRepository;

    // Transactional é usado para salvar um produto direto dentro do MySQL sem precisar usar um metodo com o EntityManagerFactory
    @Transactional
    public Produto salvandoItens (Produto produto) {
        //Sempre que tiver um relacionamento de tabela, adicionar exatamente o que a tabela principal pede em seus dados
        //Relacionamento de tabela produto com entradas
        //Entradas tem quantidade e preço unitario
        //Abaixo estou inserindo em entradaProduto o produto em si a quantidade e o preço
        Produto produtoSalvo = produtoRepository.save(produto);
        ItensVenda entradaItensVenda = new ItensVenda();
        Entrada entradaProduto = new Entrada();
        Venda vendaProduto = new Venda();
        Double valorTotal = produto.getPrecoProduto() * produto.getQuantidadeProduto();
        vendaProduto.setValor_total(valorTotal);
        vendaProduto.setForma_pagamento(Metodo.Cartao_Credito);
        Venda vendaSalva = vendaRepository.save(vendaProduto);
        entradaProduto.setProduto(produtoSalvo);
        entradaItensVenda.setProduto(produtoSalvo);
        entradaItensVenda.setVendas(vendaSalva);
        entradaItensVenda.setQuantidade(produtoSalvo.getQuantidadeProduto());
        entradaItensVenda.setSubtotal(valorTotal);
        entradaProduto.setQuantidade(produtoSalvo.getQuantidadeProduto());
        entradaItensVenda.setPrecoUnitario(produtoSalvo.getPrecoProduto());
        entradaProduto.setPrecoUnitarioDosProdutos(produtoSalvo.getPrecoProduto());
        //Logo após adicionar eu salvo ele e retorno o produto salvo no final
        itensVendaRepository.save(entradaItensVenda);
        entradaRepository.save(entradaProduto);

        return produtoSalvo;

    }

    //Fazendo a busca completo dentro do mysql por nome declarado dentro de repository
    public List<Produto> buscarNomesTodos() {
        return produtoRepository.findAll();
    }
}
