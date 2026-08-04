package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/listarFornecedores")
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.buscarTodosFornecedores();
    }


    @PostMapping("/adicionarFornecedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor adicionarFornecedor (@RequestBody Fornecedor fornecedor){
        return fornecedorService.salvandoFornecedor(fornecedor);
    }
}
