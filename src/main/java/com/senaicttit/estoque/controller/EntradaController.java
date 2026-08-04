package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Entrada;
import com.senaicttit.estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping("/listandoEntrada")
    public List<Entrada> buscandoIdProduto () {
        return entradaService.buscandoIdProduto();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrada cadastrandoEntrada (@RequestBody Entrada entrada) {
        return entradaService.salvandoEntrada(entrada);
    }
}
