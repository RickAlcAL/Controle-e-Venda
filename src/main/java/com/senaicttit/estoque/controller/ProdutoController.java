package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Produto;
import com.senaicttit.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") /* Adicionando crossorigin para falar pro fron-end que aqui terá acesso total*/

public class ProdutoController {


    //Conectando o ProdutoService onde possui o metodo de busca com o Spring Boot ao Controller de produto
    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public List<Produto> listarProdutos() {

        return produtoService.buscarNomesTodos();

    }

    @PostMapping("/adicionarProduto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrandoProduto (@RequestBody Produto produto) {
        return produtoService.salvandoItens(produto);
    }
}
